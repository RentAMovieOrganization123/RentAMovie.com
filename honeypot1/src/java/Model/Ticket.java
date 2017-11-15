/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author AHANO
 */
public class Ticket {
    private int ID;
    private User contentOwner;
    private Date dateOfCreation;
    private String message;

    public Ticket(int ID, User contentOwner, Date dateOfCreation, String message) {
        this.ID = ID;
        this.contentOwner = contentOwner;
        this.dateOfCreation = dateOfCreation;
        this.message = message;
    }

    public Ticket(int ID, User contentOwner, String message) {
        this.ID = ID;
        this.contentOwner = contentOwner;
        this.dateOfCreation = new Date();
        this.message = message;
        
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public User getContentOwner() {
        return contentOwner;
    }

    public void setContentOwner(User contentOwner) {
        this.contentOwner = contentOwner;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
