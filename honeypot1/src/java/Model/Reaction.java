package Model;


public class Reaction extends ModifiableUserContent {
    
    User contentOwner;
    String content;

    public Reaction(User contentOwner, String content) {
        super(content);
        this.contentOwner = contentOwner;
    }

    public void changeContent(String content){
        this.setContent(content);
        super.notifyModified();
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
