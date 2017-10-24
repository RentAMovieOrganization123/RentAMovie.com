/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;


public class UserException
        extends RuntimeException
{
    
    public UserException()
    {
    }
    
    public UserException(String message)
    {
        super(message);
    }
    
    public UserException(String message, Exception innerException)
    {
        super(message, innerException);
    }
    
}
