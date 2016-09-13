package by.it.aborisenok.JD01_08;

/**
 * Created by user on 07.09.2016.
 */
abstract public class Book implements IEdition{

    private int lastPage;
    private boolean bookOpen = false;
 

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
    public abstract void listBook();

    @Override
    public abstract void doRemark();

    public int getLastPage(){
        return lastPage;
    }

    boolean isBookOpen(){return bookOpen;}
}
