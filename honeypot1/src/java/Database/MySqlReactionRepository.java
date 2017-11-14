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
import util.MySqlConnection;

public class MySqlReactionRepository implements ReactionRepository {

    private static final String SQL_SELECT_REACTION_BY_SUBJECT_ID = "SELECT * FROM `bloghoneypot`.`reactions` WHERE idSubject= ?";

    private static final String FIELD_ID_REACTION = "id";
    private static final String FIELD_NAME_USER = "nameUser";
    private static final String FIELD_CONTENT = "content";
    private static final String FIELD_SUBJECT_ID = "idSubject";

    @Override
    public List<Reaction> getReactionsBySubjectId(Subject subject) {
        List<Reaction> reactions = new ArrayList();
        try (Connection con = MySqlConnection.getConnection();
                PreparedStatement prep = con.prepareStatement(SQL_SELECT_REACTION_BY_SUBJECT_ID);) {
            prep.setInt(1, subject.getID());
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
            
            reaction = new Reaction(Repositories.getUserRepository().getUserByName(nameContentOwner), content);
        } catch (SQLException ex) {
            // throw new UserException("Unable to make a user from result set.");
            Logger.getLogger(MySqlReactionRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reaction;
    }

}
