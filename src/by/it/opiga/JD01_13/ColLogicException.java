package by.it.opiga.JD01_13;

/**
 * Created by Asus on 05.10.2016.
 */
public class ColLogicException extends Exception {
    public ColLogicException() {
    }

    public ColLogicException(String message, Throwable exception) {
        super(message, exception);
    }

    public ColLogicException(String message) {
        super(message);
    }

    public ColLogicException(Throwable exception) {
        super(exception);
    }

}
