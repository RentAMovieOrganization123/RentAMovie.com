package exceptions;


public class ImageException extends RuntimeException {

    public ImageException(String cannot_read_immage) {
        super(cannot_read_immage);
    }

}
