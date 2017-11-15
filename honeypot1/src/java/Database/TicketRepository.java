/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.Ticket;
import java.util.List;

/**
 *
 * @author AHANO
 */
public interface TicketRepository {
    public void insertTicket(Ticket ticket);
    public List<Ticket> getAllTickets();
}
