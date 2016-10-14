package by.it.prymshyts.matlab;

/**
 * Структуру можно посмотреть в pdf файле 'MatlabUML'.
 */

public class Runner {

    public static void main(String[] args) {

        try {

            Reporter reporter = new Reporter();
            reporter.setReportBuilder(new FullReportBuilder());

            String expression = "A = 2 + 5.3";
            reporter.saveToReport("Операция: " + expression + "\nОтвет: " + Parser.parse(expression));
            expression = "B = A * 3.5";
            reporter.saveToReport("Операция: " + expression + "\nОтвет: " + Parser.parse(expression));
            expression = "B1 = B - 0.55";
            reporter.saveToReport("Операция: " + expression + "\nОтвет: " + Parser.parse(expression));
            expression = "B2 = A / 2";
            reporter.saveToReport("Операция: " + expression + "\nОтвет: " + Parser.parse(expression));
            expression = "C = B + (A * 2)";
            reporter.saveToReport("Операция: " + expression + "\nОтвет: " + Parser.parse(expression));
            expression = "D = ((C - 0.15) - 20) / (7 - 5)";
            reporter.saveToReport("Операция: " + expression + "\nОтвет: " + Parser.parse(expression));
            expression = "E = {2, 3} * (D / 2)";
            reporter.saveToReport("Операция: " + expression + "\nОтвет: " + Parser.parse(expression));

            reporter.printReport();

            reporter.setReportBuilder(new BriefReportBuilder());

            expression = "A = 2 + 5.3";
            reporter.saveToReport("Операция: " + expression + "\nОтвет: " + Parser.parse(expression));
            expression = "B = A * 3.5";
            reporter.saveToReport("Операция: " + expression + "\nОтвет: " + Parser.parse(expression));
            expression = "B1 = B - 0.55";
            reporter.saveToReport("Операция: " + expression + "\nОтвет: " + Parser.parse(expression));
            expression = "B2 = A / 2";
            reporter.saveToReport("Операция: " + expression + "\nОтвет: " + Parser.parse(expression));
            expression = "C = B + (A * 2)";
            reporter.saveToReport("Операция: " + expression + "\nОтвет: " + Parser.parse(expression));
            expression = "D = ((C - 0.15) - 20) / (7 - 5)";
            reporter.saveToReport("Операция: " + expression + "\nОтвет: " + Parser.parse(expression));
            expression = "E = {2, 3} * (D / 2)";
            reporter.saveToReport("Операция: " + expression + "\nОтвет: " + Parser.parse(expression));

            reporter.printReport();

        } catch (IllegalVariableSizeException | IllegalOperationException | DivisionByZeroException e) {
            Console.printWarning("Ошибка: " + e.getMessage());
            Log.logException(e);
        }
    }
}
