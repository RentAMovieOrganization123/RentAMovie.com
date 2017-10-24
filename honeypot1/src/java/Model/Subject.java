package Model;
import java.util.ArrayList;
import java.util.Date;


public class Subject extends ModifiableUserContent {
    
    private User contentOwner;
    private ArrayList<Reaction> reactions;
    
    public Subject(User contentOwner, String content){
        super(content);
        this.contentOwner = contentOwner;
        this.reactions = new ArrayList<>();
    }

    public User getContentOwner() {
        return contentOwner;
    }

    public void setContentOwner(User contentOwner) {
        this.contentOwner = contentOwner;
    }
    
    public void addReaction(Reaction newReaction){
        reactions.add(newReaction);
    }
    
    public Reaction getReaction(Reaction reaction){
        Reaction theReaction = reactions.get(reactions.indexOf(reaction));
        return theReaction;
    }
    
    public void alterReaction(Reaction reaction, String newContent){
        Reaction theReaction = getReaction(reaction);
        reactions.remove(theReaction);
        theReaction.changeContent(newContent);
        reactions.add(reaction);
        
    }
    
    public ArrayList<Reaction> getReactions(){
        ArrayList<Reaction> returnReactions = new ArrayList<>();
        returnReactions.addAll(reactions);
        return returnReactions;
    }
    
}
