/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.Reaction;
import Model.Subject;
import java.util.List;


public interface ReactionRepository
{
    public List<Reaction> getReaction();
    public List<Reaction> getReactionBySubject(Subject subject);
    public List<Reaction> getReactionBySubjectId(int id);
    public void addReaction(Reaction reaction);
    public Subject getSubjectFromReaction(Reaction react);
}
