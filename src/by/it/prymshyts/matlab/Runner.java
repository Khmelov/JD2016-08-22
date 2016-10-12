package by.it.prymshyts.matlab;

/**
 * Структуру можно посмотреть в pdf файле 'MatlabUML'.
 */

public class Runner {

    public static void main(String[] args) {

        try {

            Log.println(Parser.parse("A = 2 + 5.3"));
            Log.println(Parser.parse("B = A * 3.5"));
            Log.println(Parser.parse("B1 = B - 0.55"));
            Log.println(Parser.parse("B2 = A / 2"));
            Log.println(Parser.parse("C = B + (A * 2)"));
            Log.println(Parser.parse("D = ((C - 0.15) - 20) / (7 - 5)"));
            Log.println(Parser.parse("E = {2, 3} * (D / 2)"));

        } catch (IllegalVariableSizeException | IllegalOperationException | DivisionByZeroException e) {
            Log.printWarning("Ошибка: " + e.getMessage());
            Log.logException(e.getMessage());
        }
    }
}
