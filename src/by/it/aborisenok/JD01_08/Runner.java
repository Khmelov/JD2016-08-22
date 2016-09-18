package by.it.aborisenok.JD01_08;

/**
 * Created by Лёша on 13.09.2016.
 */
public class Runner {
    public static void main(String[] args) {
        Book encyclopedia = new Encyclopedia("Всё о жуках", 1345);
        encyclopedia.readBook();
        encyclopedia.openBook();
        encyclopedia.readBook();
        encyclopedia.listBook();
        encyclopedia.doRemark();
        encyclopedia.closeBook();
        ((Encyclopedia)encyclopedia).killSpider();
        encyclopedia.lendBook();
        System.out.println(encyclopedia.toString());
        System.out.println("-----------------------------------");
        Book wikipedia = new Wikipedia("Жесткокрылые", 20, "https://ru.wikipedia.org/wiki/Жесткокрылые");
        wikipedia.readBook();
        wikipedia.openBook();
        wikipedia.readBook();
        wikipedia.listBook();
        wikipedia.doRemark();
        ((Wikipedia)wikipedia).textCopy();
        wikipedia.closeBook();
        wikipedia.lendBook();
        System.out.println(wikipedia.toString());
    }
}
