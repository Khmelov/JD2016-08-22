package by.it.aborisenok.JD01_08;

/**
 * Created by user on 07.09.2016.
 */
abstract public class Book implements IEdition{

    private String bookName;

    private boolean bookOpen = false;

    public Book(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public boolean openBook() {
        bookOpen = true;
        return bookOpen;
    }

    @Override
    public boolean closeBook() {
        bookOpen = false;
        return bookOpen;
    }

    @Override
    public void readBook(){
        if (bookOpen)
            System.out.println("Читаем книгу...");
         else
            System.out.println("Не могу читать, сразу нужно открыть книгу");
    }

    @Override
    public void listBook(){
        if (bookOpen)
            System.out.println("Листаем книгу...");
        else
            System.out.println("Не могу листать, сразу нужно открыть книгу");
    }

    @Override
    public  void doRemark(){
        if (bookOpen)
            System.out.println("Делаем пометки в книге...");
        else
            System.out.println("Не могу пометить, сразу нужно открыть книгу");
    }

    @Override
    public void lendBook() {
        System.out.println("Отдолжили книгу другу");
    }

    public String getBookName(){
        return bookName;
    }

    boolean isBookOpen(){return bookOpen;}

    @Override
    public String toString() {
        return "Book name - " + getBookName();
    }
}
