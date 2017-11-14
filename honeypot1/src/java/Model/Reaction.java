package Model;


public class Reaction  {
    
    User contentOwner;
    String content;

    public Reaction(User contentOwner, String content) {
        
        this.contentOwner = contentOwner;
    }

    public void changeContent(String content){
        this.setContent(content);
        
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
