package by.it.aborisenok.JD01_08;

/**
 * Created by Лёша on 12.09.2016.
 */
public class ElectricBook extends Book {

    private String bookName;

    public ElectricBook(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean openBook() {
        
        return ;
    }

    @Override
    public boolean closeBook() {
        return super.closeBook();
    }

    @Override
    public void listBook() {
        super.listBook();
    }

    @Override
    public void doRemark() {
        super.doRemark();
    }
}
