package Database;

import Model.Reaction;
import Model.Subject;
import Model.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.owasp.encoder.Encode;
import util.MySqlConnection;

public class MySqlReactionRepository implements ReactionRepository {

    private static final String SQL_SELECT_REACTION_BY_SUBJECT_ID = "SELECT * FROM `bloghoneypot`.`reactions` WHERE idSubject= ?";
    private static final String SQL_INSERT_REACTION = "INSERT INTO `bloghoneypot`.`reactions`(`nameUser`,`content`,`idSubject`) VALUES (?,?,?);";

    private static final String FIELD_ID_REACTION = "id";
    private static final String FIELD_NAME_USER = "nameUser";
    private static final String FIELD_CONTENT = "content";
    private static final String FIELD_SUBJECT_ID = "idSubject";

    @Override
    public List<Reaction> getReactionsBySubjectId(int id) {
        List<Reaction> reactions = new ArrayList();
        try (Connection con = MySqlConnection.getConnection();
                PreparedStatement prep = con.prepareStatement(SQL_SELECT_REACTION_BY_SUBJECT_ID);) {
            prep.setInt(1, id);
            ResultSet rs = prep.executeQuery();
            Reaction reaction;

            while (rs.next()) {
                reaction = this.resultSet2Subject(rs);
                reactions.add(reaction);
            }

            return reactions;
        } catch (SQLException ex) {
            //throw new UserException("Unable to get users from database.");
            Logger.getLogger(MySqlUserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private Reaction resultSet2Subject(ResultSet rs) {
        Reaction reaction = null;
        /*
        User contentOwner;
        String content;

         public Reaction(User contentOwner, String content) {
        
        this.contentOwner = contentOwner;
         }
         */
        try {
            String nameContentOwner = rs.getString(FIELD_NAME_USER);
            String content = rs.getString(FIELD_CONTENT);
            int id = rs.getInt(FIELD_SUBJECT_ID);
            reaction = new Reaction(Repositories.getUserRepository().getUserByName(nameContentOwner), content,Repositories.getSubjectRepository().getSubjectByID(id));
        } catch (SQLException ex) {
            // throw new UserException("Unable to make a user from result set.");
            Logger.getLogger(MySqlReactionRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reaction;
    }

    @Override
    public void insertReaction(Reaction reaction) {
     try(Connection con = MySqlConnection.getConnection();
            PreparedStatement prep = con.prepareStatement(SQL_INSERT_REACTION, PreparedStatement.RETURN_GENERATED_KEYS))
        {
            //"INSERT INTO `bloghoneypot`.`reactions`(`nameUser`,`content`,`idSubject`) VALUES ?,?,?);"
            prep.setString(1, Encode.forHtml(reaction.getContentOwner().getUserName()));
            prep.setString(2, Encode.forHtml(reaction.getContent()));
            prep.setInt(3, reaction.getSubject().getID());
            prep.executeUpdate();
            } catch (SQLException ex) { 
          //throw new UserException("Cannot create User",ex);
           Logger.getLogger(MySqlUserRepository.class.getName()).log(Level.SEVERE, null, ex);
      }    
    }

}
