/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.Reaction;
import Model.User;
import exceptions.ReactionException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.MySqlConnection;

/**
 *
 * @author maysam
 */
//werk altijd met interfaces zodat je automarisch kan zien welke methodes je vergeten bent
public class MySqlUserRepository implements UserRepository {

    //Lege constructor omdat de Repositories class deze aanmaakt en omdat er geen prameters nodig zijn
    public MySqlUserRepository() {
    }
    //er is geen sql connection nodig want dit gebeurd in de MySqlConnection object die opgehaald wordt in deze object
    private static final String SQL_SELECT_ALL_USERS = "SELECT * FROM `bloghoneypot`.`users`";
    //alle collomen namen worden bijgehouden in static final vaiabele zo dat ze makelijk kunnen aangepast worden.
    private static final String NAME_COLUMN = "name";
    private static final String FIRST_NAME_COLUMN = "firstname";
    private static final String BIRTH_DATE_COLUMN = "birthdate";
    private static final String COUNTRY_COLUMN = "country";

    
    public List<User> getUsers() {
        {
            try (Connection con = MySqlConnection.getConnection();
                    PreparedStatement prep = con.prepareStatement(SQL_SELECT_ALL_USERS);
                    ResultSet rs = prep.executeQuery()) {
                List<User> users = new ArrayList<>();

                while (rs.next()) {
                    User user = this.resultSet2Subject(rs);

                    users.add(user);
                }

                return users;
            } catch (SQLException ex) {
                throw new ReactionException("Unable to get reactions from database.", ex);
            }
        }
    }

    private User resultSet2Subject(ResultSet rs) {
        User user = null;
        try {
            String username = rs.getString(NAME_COLUMN);
            String userFirstName = rs.getString(FIRST_NAME_COLUMN);
            int userBirthDate = rs.getInt(BIRTH_DATE_COLUMN);
            String userCountry = rs.getString(COUNTRY_COLUMN);
            user = new User(username, userFirstName, new Date(userBirthDate), userCountry);
        } catch (SQLException ex) {
            Logger.getLogger(MySqlUserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
}
