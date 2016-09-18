package by.it.aborisenok.JD01_08;

/**
 * Created by user on 07.09.2016.
 */
public class Encyclopedia extends Book {

    private int pagesAmount;

    public Encyclopedia(String bookName, int pagesAmount) {
        super(bookName);
        this.pagesAmount = pagesAmount;
    }

    public int getPagesAmount(){
        return pagesAmount;
    }

    public void killSpider(){
        if (this.pagesAmount < 100){
            System.out.println("Бум!");
        } if (this.pagesAmount >= 100 && this.pagesAmount < 500){
            System.out.println("Баам!!");
        } if (this.pagesAmount >=500){
            System.out.println("БааБаааммм!!!");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " | " + "Pages amount - " + pagesAmount;
    }
}
