/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.User;
import exceptions.ReactionException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maysam
 */
public class MySQLUserQueries {
    
    private static MySQLUserQueries instance;
    public Connection conn;
    //online DB
    private static final String URL = "jdbc:mysql://localhost/honeypot";
    private static final String USR = "honeypot2017";
    private static final String PWD = "honeypot2017";
    
    private MySQLUserQueries() { this.initConnection(); }
   
    public static MySQLUserQueries getInstance() {

        if (instance == null) {
            synchronized (MySQLUserQueries.class) {
                if (instance == null)  {
                    instance = new MySQLUserQueries(); }
            }
        }
        return instance;
    }
    
    public void initConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USR, PWD);
        }
        catch (ClassNotFoundException e) {
            throw new ReactionException("There is a problem connecting to database", e);
        } 
        catch (SQLException e) {
            throw new ReactionException("There is a problem connecting to database", e);
        }
    }
    
    //method to get users list
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        try {
            String sql = "SELECT * FROM user";
            PreparedStatement prep = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = prep.executeQuery();
            while(rs.next())
            {
                User user = new User(rs.getString("name"), rs.getString("firstName"), rs.getDate("birthday"), rs.getString("country"));
                users.add(user);
            }
            return users;
        }
        catch (SQLException e)
        {
            throw new ReactionException("A problem accured while retreiving user list", e);
        }
    }
}
