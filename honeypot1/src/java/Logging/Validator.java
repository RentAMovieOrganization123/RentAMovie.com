package Logging;

import static Logging.Logger.logSqli;
import static Logging.Logger.logXss;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.ServletRequest;

public class Validator {

    public static void validateRequest(ServletRequest request) {
        Map map = request.getParameterMap();
        Iterator i = map.keySet().iterator();
        
        while (i.hasNext()) {
            String key = (String) i.next();
            String value = ((String[]) map.get(key))[0];
            if (stringContainsItemFromList(value,sqliCharacters)) {
              logSqli(request);  
            }else if (stringContainsItemFromList(value,xssCharacters)) {
                logXss(request);
            }
        }
    }

     static String[] sqliCharacters = {
        "'",
        "--",
        " OR ",
        " or ",
        " Or",
        " oR ",
        "\\",
        "\"",
        "%"
    };

     static String[] xssCharacters = {
        "<",
        ">",
        "javascript:",
        "&",
        "\""};

    public static boolean stringContainsItemFromList(String inputStr, String[] items) {
        for (int i = 0; i < items.length; i++) {
            if (inputStr.contains(items[i])) {
                return true;
            }
        }
        return false;
    }
}
