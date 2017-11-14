/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.Reaction;
import Model.Subject;
import java.util.List;

/**
 *
 * @author AXANO
 */
public interface ReactionRepository {
    List<Reaction> getReactionsBySubjectId(Subject subject);
    
}
