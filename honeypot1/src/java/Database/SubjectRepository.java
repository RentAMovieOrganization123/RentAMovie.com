/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.Reaction;
import Model.Subject;
import java.util.List;


public interface SubjectRepository
{
    public List<Subject> getSubjects();
    public void addSubject(Subject subject);
    
}
