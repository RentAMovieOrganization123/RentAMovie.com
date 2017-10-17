package Logging;

import java.util.Iterator;
import java.util.Map;


public class Validator {
    
    public static void validateRequest(Map map){
    Iterator i = map.keySet().iterator();

        while (i.hasNext()) {
            String key = (String) i.next();
            String value = ((String[]) map.get(key))[0];
            
        }
    }
    
}
