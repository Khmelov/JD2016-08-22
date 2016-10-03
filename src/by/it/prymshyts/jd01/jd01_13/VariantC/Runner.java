package by.it.prymshyts.jd01.jd01_13.VariantC;

/**
 * Свой тип исключений - NonexistentItemException.
 * Пробрасывается в определении метода moveTo, в абстрактном классе Cupboard, в том случае,
 * если в качестве аргумента приходит 'несуществующий объект' или null.
 */

public class Runner {

    public static void main(String[] args) {

        Cupboard cupboard = new Bookcase();

        try {
            cupboard.moveTo("стене");
            cupboard.moveTo("холодильник");
            cupboard.moveTo("несуществующий предмет");
        } catch (NonexistentItemException e) {
            System.err.println(e.getMessage());
            cupboard.moveTo("прежней позиции");
        }

        try {
            cupboard.moveTo("окну");
            cupboard.moveTo(null);
        } catch (NonexistentItemException e) {
            System.err.println(e.getMessage());
            cupboard.moveTo("прежней позиции");
        }
    }
}
