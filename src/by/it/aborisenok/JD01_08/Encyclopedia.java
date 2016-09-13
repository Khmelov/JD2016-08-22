package by.it.aborisenok.JD01_08;

/**
 * Created by user on 07.09.2016.
 */
public class Encyclopedia extends Book {

    private String bookName;

    public Encyclopedia(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public void readBook() {

    }

    @Override
    public void listBook() {

    }

    @Override
    public void doRemark() {

    }

    @Override
    public void lendBook() {

    }

    @Override
    public void killSpider() {

    }

    @Override
    public String toString() {
        return bookName;
    }
}
