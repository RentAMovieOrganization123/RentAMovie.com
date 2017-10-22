package Model;
import java.util.ArrayList;
import java.util.Date;


public class Subject extends ModifiableUserContent {
    
    private User user;
    private String content;
    private ArrayList<Reaction> reactions;
    
    public Subject(User user, String content){
        super();
        this.user = user;
        this.content = content;
        this.reactions = new ArrayList<>();
    }

    public User getUser() {
        return user;
    }
    
     public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
}
