/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;


public class Repositories
{
    //private static final ReactionRepository movieRepository = new MySqlReactionRepository();
    //private static final LogEventRepository LogEventRepository = new MySqlLogEventRepository();
    
    
    private Repositories()
    {
    } 
    
    public static SubjectRepository getMovieRepository()
    {
        return new MySqlSubjectRepository();
    }
    
 public static LogEventRepository getLogEventRepository()
    {
        return  new MySqlLogEventRepository();
    }
    
 public static UserRepository getUserRepository()
    {
        return  new MySqlUserRepository();
    }
    
}
