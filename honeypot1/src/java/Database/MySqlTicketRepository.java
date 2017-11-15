/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.Reaction;
import Model.Subject;
import Model.Ticket;
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
import util.MySqlConnection;

/**
 *
 * @author AHANO
 */
public class MySqlTicketRepository implements TicketRepository{
    private static final String SQL_SELECT_ALL_TICKETS = "SELECT * FROM bloghoneypot.ticket;";
    private static final String SQL_ADD_TICKET = "INSERT INTO `bloghoneypot`.`ticket` (`username`,`dateofcreation`,`message`) VALUES (?,?,?);";


    private static final String FIELD_TICKET_ID = "Id";
    private static final String FIELD_USERNAME = "username";
    private static final String FIELD_DATEOFCREATION = "dateofcreation";
    private static final String FIELD_MESSAGE = "message";
    
    
    @Override
    public void insertTicket(Ticket ticket) {
        try(Connection con = MySqlConnection.getConnection();
            PreparedStatement prep = con.prepareStatement(SQL_ADD_TICKET, PreparedStatement.RETURN_GENERATED_KEYS))
        {
            prep.setString(1, Encode.forHtml(ticket.getContentOwner().getUserName()));
            prep.setLong(2,ticket.getDateOfCreation().getTime() );
            prep.setString(3, Encode.forHtml(ticket.getMessage()));
            prep.executeUpdate();
            } catch (SQLException ex) { 
          //throw new UserException("Cannot create User",ex);
           Logger.getLogger(MySqlUserRepository.class.getName()).log(Level.SEVERE, null, ex);
      } 
    }

    @Override
    public List<Ticket> getAllTickets() {
                     try(Connection con = MySqlConnection.getConnection();
            PreparedStatement prep = con.prepareStatement(SQL_SELECT_ALL_TICKETS);
            ResultSet rs = prep.executeQuery())
        {
            List<Ticket> tickets = new ArrayList<>();
            
            while (rs.next())
            {
                Ticket ticket = this.resultSet2Ticket(rs);
                
                tickets.add(ticket);
            }
            
            return tickets;
        }
        catch (SQLException ex)
        {
            throw new ReactionException("Unable to get reactions from database.", ex);
        }
    }
 
    private Ticket resultSet2Ticket(ResultSet rs) throws SQLException
    {
       

        Ticket ticket = null;
        try {
            int id = rs.getInt(FIELD_TICKET_ID);
            User contentOwner = Repositories.getUserRepository().getUserByName(rs.getString(FIELD_USERNAME));
            
            
            long creationTimeMillis = rs.getLong(FIELD_DATEOFCREATION);
            String message= rs.getString(FIELD_MESSAGE);
            ticket = new Ticket(id, contentOwner,new Date(creationTimeMillis),message);
        } catch (SQLException ex) {
           // throw new UserException("Unable to make a user from result set.");
           Logger.getLogger(MySqlSubjectRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ticket;
    }
}
