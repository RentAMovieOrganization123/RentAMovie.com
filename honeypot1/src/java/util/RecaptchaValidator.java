package util;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;


public class RecaptchaValidator {
private static final String URL="https://www.google.com/recaptcha/api/siteverify?secret=6LcciDUUAAAAAPfGZjKA_pwVve1qNeueGClO7qsw&response=";//response_string&remoteip=user_ip_address";




public static boolean verifyResponse(String response) throws JSONException{
    JSONObject jo = null;
    try {
        jo = (JSONObject) new JSONTokener(IOUtils.toString(new URL(URL+response))).nextValue();
        
    } catch (IOException ex) {
        return false;
    } 
    boolean result = jo.getBoolean("success");
    return result;
}
}
/*{
  "success": true|false,
  "challenge_ts": timestamp,  // timestamp of the challenge load (ISO format yyyy-MM-dd'T'HH:mm:ssZZ)
  "hostname": string,         // the hostname of the site where the reCAPTCHA was solved
  "error-codes": [...]        // optional
}*/