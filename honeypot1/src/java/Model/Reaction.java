package Model;


public class Reaction extends ModifiableUserContent {
    User contentOwner;
    String content;

    public Reaction(User contentOwner, String content) {
        this.contentOwner = contentOwner;
        this.content = content;
    }

    
    
    public User getContentOwner() {
        return contentOwner;
    }

    public void setContentOwner(User contentOwner) {
        this.contentOwner = contentOwner;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    
}
