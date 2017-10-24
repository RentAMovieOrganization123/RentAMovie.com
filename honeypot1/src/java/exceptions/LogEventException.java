package exceptions;


public class LogEventException extends RuntimeException{
    public LogEventException(String message)
    {
        super(message);
    }
    
    public LogEventException(String message, Exception innerException)
    {
        super(message, innerException);
    }
}
