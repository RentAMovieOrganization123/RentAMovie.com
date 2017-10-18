package Database;

import Model.LogEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.MySqlConnection;


public class MySqlLogEventRepository implements LogEventRepository{
  private static final String SQL_INSERT_LOG_ENTRY = "INSERT INTO `bloghoneypot`.`logentries`"
            + "(`ip`,`mac`,`vendor`,`action`,`requestString`,`timeOfEvent`) "
            + "VALUES (?,?,?,?,?,?);";

    public MySqlLogEventRepository() {
    }
   
    @Override
    public void insertLogEntry(LogEvent logEvent) {
         try(Connection con = MySqlConnection.getConnection();
            PreparedStatement prep = con.prepareStatement(SQL_INSERT_LOG_ENTRY, PreparedStatement.RETURN_GENERATED_KEYS))
        {
            prep.setString(1, logEvent.getIp());
            prep.setString(2, logEvent.getMac());
            prep.setString(3, logEvent.getVendor());
            prep.setString(4, logEvent.getAction());
            prep.setString(5, logEvent.getRequestString());
            prep.setString(6, logEvent.getTimeOfEvent());
            
            prep.executeUpdate();
            } catch (SQLException ex) { 
          Logger.getLogger(MySqlLogEventRepository.class.getName()).log(Level.SEVERE, null, ex);
      } 
        }

}
