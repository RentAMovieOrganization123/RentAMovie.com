package test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
 import org.owasp.encoder.Encode;
public class runTest {

    public static void main(String[] args) {
     String message = "<Onvertrouwba'ar% bericht gehaald uit databes";
 String veiligeMessage = Encode.forHtml(message);
    System.out.println(veiligeMessage);   
        

    }

}
