package Model;

public class Reaction  {
    
    private User contentOwner;
    private String content;
    private Subject subject;
    public Reaction(User contentOwner, String content,Subject subject) {
        this.content = content;
        this.contentOwner = contentOwner;
        this.subject = subject;
        
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
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
