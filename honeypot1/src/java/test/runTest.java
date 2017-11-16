package test;

import Database.Repositories;
import Model.Subject;
import Model.User;
import java.util.ArrayList;
import java.util.Date;
public class runTest {

    public static void main(String[] args) {
        byte[] b= {'b'};
        User user = new User("","","emmanouil4","123456789",new Date(),"greece",b,"");
        Subject subject  = new Subject(1,user,new ArrayList(),new Date(),"TEST");
        Repositories.getSubjectRepository().addSubject(subject);
        Subject s2 = Repositories.getSubjectRepository().getSubjectByID(2);
        System.out.println(s2.getDateOfCreation().toString());
    }

}
