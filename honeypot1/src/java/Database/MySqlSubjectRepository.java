/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import util.MySqlConnection;
import Model.Subject;
import Model.Reaction;
import Model.User;
import exceptions.ReactionException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.owasp.encoder.Encode;


public class MySqlSubjectRepository
        implements SubjectRepository
{
    private static final String SQL_SELECT_ALL_SUBJECTS = "SELECT * FROM bloghoneypot.subject;";
    private static final String SQL_SELECT_SUBJECT_BY_ID = "select * from bloghoneypot.subject where id = ?";
    private static final String SQL_ADD_SUBJECT = "insert into bloghoneypot.subject(name, creationDateTime, userName) values(?, ?, ?)";


    private static final String FIELD_SUBJECT_ID = "Id";
    private static final String FIELD_SUBJECT_NAME = "name";
    private static final String FIELD_SUBJECT_CREATIONDATETIME = "creationDateTime";
    private static final String FIELD_SUBJECT_USER_NAME = "userName";
    

    MySqlSubjectRepository()
    {
    }
    
    @Override
    public List<Subject> getSubjects()
    {
        try(Connection con = MySqlConnection.getConnection();
            PreparedStatement prep = con.prepareStatement(SQL_SELECT_ALL_SUBJECTS);
            ResultSet rs = prep.executeQuery())
        {
            List<Subject> subjects = new ArrayList<>();
            
            while (rs.next())
            {
                Subject subject = this.resultSet2Subject(rs);
                
                subjects.add(subject);
            }
            
            return subjects;
        }
        catch (SQLException ex)
        {
            throw new ReactionException("Unable to get subjects from database.", ex);
        }
    }
    

        
    @Override
    public void addSubject(Subject subject)
    {
        try(Connection con = MySqlConnection.getConnection();
            PreparedStatement prep = con.prepareStatement(SQL_ADD_SUBJECT, PreparedStatement.RETURN_GENERATED_KEYS))
        {
          
            prep.setString(1, Encode.forHtml(subject.getName()));
            prep.setLong(2, subject.getDateOfCreation().getTime());
           prep.setString(3, Encode.forHtml(subject.getContentOwner().getUserName()));
           
            
            prep.executeUpdate();
                    
            try(ResultSet rs = prep.getGeneratedKeys())
            {
                int newReactionId = -1;
                
                if (rs.next())
                {
                    newReactionId = rs.getInt(1);
                }
                
                if (newReactionId < 0)
                {
                    throw new ReactionException("Unable to add subject to database.");
                }
                
                //reaction.setId(newReactionId);
            }
        }
        catch (SQLException ex)
        {
            throw new ReactionException("Unable to add subject to database.");
        }
    }
    
    private Subject resultSet2Subject(ResultSet rs) throws SQLException
    {
       

        Subject subject = null;
        try {
            int id = rs.getInt(FIELD_SUBJECT_ID);
            User contentOwner = Repositories.getUserRepository().getUserByName(rs.getString(FIELD_SUBJECT_USER_NAME));
            List<Reaction> reactions = Repositories.getReactionRepository().getReactionsBySubjectId(id);//rs.getString(USER_NAME_COLUMN); TODO get reactons with subjectID
            
            long creationTimeMillis = rs.getLong(FIELD_SUBJECT_CREATIONDATETIME);
            String name = rs.getString(FIELD_SUBJECT_NAME);
            subject = new Subject(id, contentOwner,reactions,new Date(creationTimeMillis), name);
        } catch (SQLException ex) {
           throw new ReactionException("Unable to make a subject from result set.");
          //Logger.getLogger(MySqlSubjectRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return subject;
    }

    @Override
    public Subject getSubjectByID(int id) {
       try (Connection con = MySqlConnection.getConnection();
                    PreparedStatement prep = con.prepareStatement(SQL_SELECT_SUBJECT_BY_ID);
                    ) {
                    prep.setInt(1, id);
                    ResultSet rs = prep.executeQuery();
                Subject subject=null;

                while (rs.next()) {
                    subject = this.resultSet2Subject(rs);

                }
                    
                        rs.close();
                return subject;
            } catch (SQLException ex) {
                throw new ReactionException("Unable to add subject to database.");
                 //Logger.getLogger(MySqlSubjectRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
       
    }

    

   
    
}
