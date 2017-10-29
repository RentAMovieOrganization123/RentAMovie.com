/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.Reaction;
import Model.User;
import java.util.List;

/**
 *
 * @author AXANO
 */
public interface UserRepository {
    public List<User> getUsers();
    public User getUserByName(String name);   
    public void insertUser(User user);
}
