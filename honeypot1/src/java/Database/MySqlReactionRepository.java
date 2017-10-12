/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import util.MySqlConnection;
import Model.Subject;
import Model.Reaction;
import exceptions.ReactionException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MySqlReactionRepository
        implements ReactionRepository
{
    private static final String SQL_SELECT_ALL_MOVIES = "select * from reaction";
    private static final String SQL_SELECT_MOVIES_BY_GENRE_ID = "select * from reaction where subject_id = ?";
    private static final String SQL_ADD_MOVIE = "insert into reaction(title, subject_id, year, stars) values(?, ?, ?, ?)";

    private static final String FIELD_ID = "id";
    private static final String FIELD_TITLE = "title";
    private static final String FIELD_GENRE_ID = "subject_id";
    private static final String FIELD_YEAR = "year";
    private static final String FIELD_STARS = "stars";

    MySqlReactionRepository()
    {
    }
    
    public List<Reaction> getReactions()
    {
        try(Connection con = MySqlConnection.getConnection();
            PreparedStatement prep = con.prepareStatement(SQL_SELECT_ALL_MOVIES);
            ResultSet rs = prep.executeQuery())
        {
            List<Reaction> reactions = new ArrayList<>();
            
            while (rs.next())
            {
                Reaction reaction = this.resultSet2Subject(rs);
                
                reactions.add(reaction);
            }
            
            return reactions;
        }
        catch (SQLException ex)
        {
            throw new ReactionException("Unable to get reactions from database.", ex);
        }
    }
    
    public List<Reaction> getReactionBySubjectId(int id)
    {
        List<Reaction> reactions = new ArrayList<>();
        try(Connection con = MySqlConnection.getConnection();
            PreparedStatement prep = con.prepareStatement(SQL_SELECT_MOVIES_BY_GENRE_ID);
            )
        {
            
            prep.setInt(1, id);
            try(
            ResultSet rs = prep.executeQuery()){
            
            
            while (rs.next())
            {
                Reaction reaction = this.resultSet2Subject(rs);
                
                reactions.add(reaction);
            }
            
            return reactions;
        }
        catch (SQLException ex)
        {
            throw new ReactionException("Unable to get reactions from database.", ex);
        }
       
    }   catch (SQLException ex) {
            Logger.getLogger(MySqlReactionRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
         return reactions;
    }
    public void addReaction(Reaction reaction)
    {
        try(Connection con = MySqlConnection.getConnection();
            PreparedStatement prep = con.prepareStatement(SQL_ADD_MOVIE, PreparedStatement.RETURN_GENERATED_KEYS))
        {
            //prep.setString(1, reaction.getTitle());
            //prep.setInt(2, reaction.getSubject().getId());
           // prep.setInt(3, reaction.getYear());
           // prep.setInt(4, reaction.getStars());
            
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
                    throw new ReactionException("Unable to add reaction to database.");
                }
                
                //reaction.setId(newReactionId);
            }
        }
        catch (SQLException ex)
        {
            throw new ReactionException("Unable to add reaction to database.", ex);
        }
    }
    
    private Reaction resultSet2Subject(ResultSet rs) throws SQLException
    {
        int id = rs.getInt(FIELD_ID);
        String title = rs.getString(FIELD_TITLE);

        int subjectId = rs.getInt(FIELD_GENRE_ID);
        //Subject subject = Repositories.getSubjectRepository().getSubject(subjectId);

        int year = rs.getInt(FIELD_YEAR);
        int stars = rs.getInt(FIELD_STARS);

        //Reaction reaction = new Reaction(id, title, subject, year, stars);
        Reaction reaction = new Reaction();

        return reaction;
    }

    @Override
    public List<Reaction> getReaction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 

 

    @Override
    public List<Reaction> getReactionBySubject(Subject subject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
