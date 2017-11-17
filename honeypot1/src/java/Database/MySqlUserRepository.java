/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.User;
import exceptions.UserException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.owasp.encoder.Encode;
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
    private static final String SQL_SELECT_USER_BY_NAME = "SELECT * FROM `bloghoneypot`.`users` WHERE userName = ?";
    private static final String SQL_INSERT_USER = "INSERT INTO `bloghoneypot`.`users`(`name`,`firstname`,`username`,`password`,`birthDate`,`country`,`profilepicture`)"
                                                + "VALUES(?,?,?,?,?,?,?)";
    
    private static final String NAME_COLUMN = "name";
    private static final String FIRST_NAME_COLUMN = "firstName";
    private static final String USER_NAME_COLUMN = "userName";
    private static final String PASSWORD_COLUMN = "password";
    private static final String BIRTH_DATE_COLUMN = "birthDate";
    private static final String COUNTRY_COLUMN = "country";
    private static final String PROFILE_PICTURE_COLUMN = "profilePicture";
    private static final String ISADMIN_COLUMN = "isAdmin";
    
    

    
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
                throw new UserException("Unable to get users from database.");
            }
        }
    }

    private User resultSet2Subject(ResultSet rs) {
        User user = null;
        try {
            String name = rs.getString(NAME_COLUMN);
            String userFirstName = rs.getString(FIRST_NAME_COLUMN);
            String userName = rs.getString(USER_NAME_COLUMN);
            String password = rs.getString(PASSWORD_COLUMN);
            long userBirthDate = rs.getLong(BIRTH_DATE_COLUMN);
            String userCountry = rs.getString(COUNTRY_COLUMN);
            byte[] profilePicture = rs.getBytes(PROFILE_PICTURE_COLUMN);
            String isAdmin = rs.getString(ISADMIN_COLUMN);
            user = new User(name, userFirstName,userName,password, new Date(userBirthDate), userCountry,profilePicture,isAdmin);
            
        } catch (SQLException ex) {
            throw new UserException("Unable to make a user from result set.");
           //Logger.getLogger(MySqlUserRepository.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return user;
    }

    @Override
    public User getUserByName(String name) {
        try (Connection con = MySqlConnection.getConnection();
                    PreparedStatement prep = con.prepareStatement(SQL_SELECT_USER_BY_NAME);
                    ) {
                    prep.setString(1, name);
                    ResultSet rs = prep.executeQuery();
                User user=null;

                while (rs.next()) {
                    user = this.resultSet2Subject(rs);

                }
                rs.close();
                return user;
            } catch (SQLException ex) {
                throw new UserException("Unable to get users from database.");
                // Logger.getLogger(MySqlUserRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
       
        }

    @Override
    public void insertUser(User user) {
        try(Connection con = MySqlConnection.getConnection();
            PreparedStatement prep = con.prepareStatement(SQL_INSERT_USER, PreparedStatement.RETURN_GENERATED_KEYS))
        {
            prep.setString(1, Encode.forHtml(user.getName()));
            prep.setString(2, Encode.forHtml(user.getFirstName()));
            prep.setString(3, Encode.forHtml(user.getUserName()));
            prep.setString(4, Encode.forHtml(user.getPassword()));
            prep.setLong(5, user.getBirthDate().getTime());
            prep.setString(6, Encode.forHtml(user.getCountry()));
            prep.setBytes(7, user.getProfilePicture());   
            prep.executeUpdate();
            } catch (SQLException ex) { 
          throw new UserException("Cannot create User",ex);
           //Logger.getLogger(MySqlUserRepository.class.getName()).log(Level.SEVERE, null, ex);
      } 
    }

    
    }

