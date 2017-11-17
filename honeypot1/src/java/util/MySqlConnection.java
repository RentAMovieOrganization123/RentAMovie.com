/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import exceptions.UserException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySqlConnection
{
    private static final String URL = "jdbc:mysql://localhost/bloghoneypot?useSSL=false";
    private static final String UID = "blogStandard";
    private static final String PWD = "****************"; //sucker als je naar deze file kijk kan je toch maar vanaf de localhost inloggen + passwoord is veranderd! :P
    
    // loading the class is only required for web applications
    static
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException ex)
        {
            throw new UserException("Unable to load database driver.", ex);
        }
    }
    
    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(URL, UID, PWD);
    }
    
}
