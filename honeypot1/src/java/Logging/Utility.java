package Logging;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Utility {
    
 public static String getMac(String ip)  {
     try {
         String systemInput = "";
         Runtime.getRuntime().exec("arp -a"); 
         Scanner s = new Scanner(Runtime.getRuntime()
                 .exec("arp -a " + ip)
                 .getInputStream())
                 .useDelimiter("\\A");
         
         systemInput = s.next();
         String mac = "";
         Pattern pattern = Pattern.compile("\\s{0,}([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})");
         Matcher matcher = pattern.matcher(systemInput);
         if (matcher.find()) {
             mac = mac + matcher.group().replaceAll("\\s", "");
         } else {
             System.out.println("No string found");
         }
         return mac;
     } catch (IOException ex) {
         Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
     }
     return null;
    }
 
 public static String getVendorByMac(String mac) {
    try (java.util.Scanner s = new java.util.Scanner(new java.net.URL("http://api.macvendors.com/"+mac).openStream())) {
      String vendor = s.useDelimiter("\\A").next();
        //System.out.println(vendor);
      return vendor;
    } catch (IOException ex) {
         return "Vendor not found";
     }
    
 }
}
