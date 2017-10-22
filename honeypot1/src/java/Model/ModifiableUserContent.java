/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Cedric Cornelis
 */
public class ModifiableUserContent {
    
     private Date dateLastModified;
     private final Date dateCreated;
     private String content;
     
     public void modifyContent(String newContent){
        content = newContent;
        notifyModified();
    }
     
     public ModifiableUserContent(){
         this.dateLastModified = new Date();
         this.dateCreated = new Date();
     }
    
    public void notifyModified(){
        this.dateLastModified = new Date();
    }
}
