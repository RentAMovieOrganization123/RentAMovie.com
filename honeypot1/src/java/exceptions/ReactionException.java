/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
