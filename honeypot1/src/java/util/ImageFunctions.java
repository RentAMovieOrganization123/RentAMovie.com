package util;


import exceptions.ImageException;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import static java.util.Arrays.stream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


public class ImageFunctions {
public static boolean isImage(byte[] bytes){
            InputStream is = new BufferedInputStream(new ByteArrayInputStream(bytes));
    boolean returnValue = false;
    try {
        if( ImageIO.read(is) != null) {
            returnValue = true;
        }
        
    } catch (IOException ex) {
        throw new ImageException("cannot read image.");
     
        }
    return returnValue;
}
}
