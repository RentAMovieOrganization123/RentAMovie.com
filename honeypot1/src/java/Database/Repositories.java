/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

/**
 *
 * @author frederic.vlummens
 */
public class Repositories
{
    private static final ReactionRepository movieRepository = new MySqlReactionRepository();
    
    
    private Repositories()
    {
    }
    
    public static ReactionRepository getMovieRepository()
    {
        return movieRepository;
    }
    

}
