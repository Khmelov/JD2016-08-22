package by.it.prymshyts.jd01_13.matlab;

/**
 * Здесь будут тестироваться всякие штуки.
 *
 * Calculator - производит все вычисления и возвращает результат.
 *
 * Я мог забыть реализовать каку-нибудь операцию, но в текущей структуре расширить функционал не сложно.
 * Её (структуру) можно посмотреть в pdf файле 'MatlabUML'.
 */

public class Runner {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        Variable f1 = new FloatVariable(2.0);
        Variable f2 = new FloatVariable(0.0);
        Variable v = new VectorVariable(new Double[]{1.0, 2.0, 3.0});
        Variable m = new MatrixVariable(new Double[][]{{1.0, 2.0, 3.0},{4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}});


        try {
            Log.println(calculator.div(f1, f2).toString());
        } catch (IllegalVariableSizeException | DivisionByZeroException e) {
            Log.printWarning("Ошибка: " + e.getMessage());
            Log.logException(e.getMessage());
        } catch (NullPointerException e) {
            Log.logException("Результат не может быть распечатан.");
        }

        Log.printExceptionLog();

//        Log.println("Вводные данные:\n-----");
//        Log.println("Целое:");
//        Log.println("f = " + f);
//        Log.print("\n");
//        Log.println("Вектор:");
//        Log.println("v = " + v);
//        Log.print("\n");
//        Log.println("Матрица:");
//        Log.println("m = " + m);
//        Log.println("-----\n");
//
//        Log.println("Сложение:\n-----");
//        Log.println("f + f = " + calculator.add(f, f));
//        Log.println("f + v = " + calculator.add(f, v));
//        Log.println("f + m = " + calculator.add(f, m));
//        Log.print("\n");
//        Log.println("v + f = " + calculator.add(v, f));
//        Log.println("v + v = " + calculator.add(v, v));
//        Log.print("\n");
//        Log.println("m + f = " + calculator.add(m, f));
//        Log.println("m + m = " + calculator.add(m, m));
//        Log.println("-----\n");
//
//        Log.println("Вычитание:\n-----");
//        Log.println("f - f = " + calculator.sub(f, f));
//        Log.println("f - v = " + calculator.sub(f, v));
//        Log.println("f - m = " + calculator.sub(f, m));
//        Log.print("\n");
//        Log.println("v - f = " + calculator.sub(v, f));
//        Log.println("v - v = " + calculator.sub(v, v));
//        Log.print("\n");
//        Log.println("m - f = " + calculator.sub(m, f));
//        Log.println("m - m = " + calculator.sub(m, m));
//        Log.println("-----\n");
//
//        Log.println("Умножение:\n-----");
//        Log.println("f * f = " + calculator.mul(f, f));
//        Log.println("f * v = " + calculator.mul(f, v));
//        Log.println("f * m = " + calculator.mul(f, m));
//        Log.print("\n");
//        Log.println("v * f = " + calculator.mul(v, f));
//        Log.print("\n");
//        Log.println("m * f = " + calculator.mul(m, f));
//        Log.println("m * v = " + calculator.mul(m, v));
//        Log.println("m * m = " + calculator.mul(m, m));
//        Log.println("-----\n");
//
//        Log.println("Деление:\n-----");
//        Log.println("f / f = " + calculator.div(f, f));
//        Log.print("\n");
//        Log.println("v / f = " + calculator.div(v, f));
//        Log.print("\n");
//        Log.println("m / f = " + calculator.div(m, f));
//        Log.println("-----\n");
    }
}
