package by.it.kisel.JD01_13;


public class TaskA {

    static void t1() {

        String str;
        Double num;
        Double sqrtSum = 0.0;

        System.out.println("Введите END для завершения.");

        while (true) {
            try {
                System.out.print("Введите число не меньше нуля: ");
                str = Util.getConsoleLine();

                if (str.equals("END")) {
                    System.out.println("Завершение программы.");
                    break;
                }

                num = getNumFromString(str);

                if (num < 0) {
                    System.out.println("Введено число меньше нуля.");
                    break;
                }

                sqrtSum += Math.sqrt(num);
                System.out.println("Число = " + num);
                System.out.println("Сумма корней всех чисел: " + sqrtSum);


            } catch (NumberFormatException e) {
                System.err.println("Введённая строка не является числом.");
            }
        }
    }

    private static Double getNumFromString(String str) throws NumberFormatException {
        return new Double(str);
    }
}

