package Model;
import java.util.ArrayList;
import java.util.Date;


public class Subject  {
    
    private int ID;
    private User contentOwner;
    private ArrayList<Reaction> reactions;
    private Date dateOfCreation;
    private String name;

    public Subject(int ID, User contentOwner, ArrayList<Reaction> reactions, Date dateOfCreation, String name) {
        this.ID = ID;
        this.contentOwner = contentOwner;
        this.reactions = reactions;
        this.dateOfCreation = dateOfCreation;
        this.name = name;
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

    public ArrayList<Reaction> getReactions() {
        return reactions;
    }

    public void setReactions(ArrayList<Reaction> reactions) {
        this.reactions = reactions;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
