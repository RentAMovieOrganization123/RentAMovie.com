package exceptions;


public class ReactionException 
       extends RuntimeException
{
    
    public ReactionException()
    {
    }
    
    public ReactionException(String message)
    {
        super(message);
    }
    
    public ReactionException(String message, Exception innerException)
    {
        super(message, innerException);
    }
    
}


