package by.it.aborisenok.JD01_08;

/**
 * Created by user on 07.09.2016.
 */
public class Encyclopedia extends Book {
    @Override
    public boolean openBook() {
        return false;
    }

    @Override
    public boolean closeBook() {
        return false;
    }

    @Override
    public String readBook() {
        return null;
    }
}
