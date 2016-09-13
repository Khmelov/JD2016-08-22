package by.it.aborisenok.JD01_08;

/**
 * Created by Лёша on 12.09.2016.
 */
public class ArtBook extends Book {

    private String bookName;

    public ArtBook(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return bookName;
    }
}
