package Model;

public class Reaction  {
    
    private User contentOwner;
    private String content;
    private int subjectId;
    public Reaction(User contentOwner, String content,int subjectId) {
        this.content = content;
        this.contentOwner = contentOwner;
        this.subjectId = subjectId;
        
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
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
