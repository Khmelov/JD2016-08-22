package by.it.voronovich.JD02_04;

/**
 * Класс описывает возможные ошибки выполнения программы
 *
 * @author Voronovich Dmitry
 * @version 1.1
 */
public class UnsupportedException extends Exception {

    public UnsupportedException() {
    }

    public UnsupportedException(String message) {
        super(message);
    }

    public UnsupportedException(Throwable exception) {
        super(exception);
    }

    public UnsupportedException(String message, Throwable exception) {
        super(message, exception);
    }

}