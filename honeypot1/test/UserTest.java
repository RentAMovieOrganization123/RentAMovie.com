/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Date;

/**
 *
 * @author Cedric Cornelis
 */
public class UserTest {
    
    Model.User u1;
    Model.User u2;
    
    public UserTest() {
    }
    
    @Test
    public void User1CorrectAge(){
        assertTrue(u1.getAge() == 23);
    }
    
    @Test
    public void User1CorrectId(){
        System.out.println(u1.getProfilePicId());
        assertTrue(u1.getProfilePicId() == 0);
    }
    
    @Test
    public void User2CorrectId(){
        System.out.println(u2.getProfilePicId());
        assertTrue(u2.getProfilePicId() == 1);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
       u1 = new Model.User("Cornelis", "Cedric", new Date(766281600000L), "Belgium"); //long value = 14 april 1994 in unix timestamp
       u2 = new Model.User("Cornelis1", "Cedric1", new Date(766281600000L), "Canada"); //long value = 14 april 1994 in unix timestamp
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
