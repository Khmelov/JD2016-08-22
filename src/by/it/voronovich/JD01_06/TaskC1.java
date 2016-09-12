package by.it.voronovich.JD01_06;

/**
 * Класс содержит тело метода для решения задачи 1 блока С
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */

public class TaskC1 {

    /**
     * Метод выполняет форматирование текста с выравниванием по обоим краям.
     *
     */
    protected static void c1() {

        String text = Data.lukomorie;
        String arrayLine[] = text.trim().split("\n");

        //найдем строку с самой большой длинной
        int maxLineLength = 0;
        for (int i = 0; i < arrayLine.length; i++) {
            if (arrayLine[i].length() > maxLineLength) {
                maxLineLength = arrayLine[i].length();
            }
        }

        System.out.println(maxLineLength);

        for (int i = 0; i < arrayLine.length; i++) {
            if (arrayLine[i].length() < maxLineLength) {
                int counter = maxLineLength - arrayLine[i].length();
                String[] word = arrayLine[i].split("\\s");

                int spaceSp = counter / (word.length - 1);
                counter = counter % (word.length - 1);

                String space = "";
                for (int j = 0; j < spaceSp; j++) {
                    space += " ";
                }

                StringBuilder updateLine = new StringBuilder();
                for (int j = 0; j < word.length; j++) {
                    if (j != word.length - 1) {
                        updateLine.append(word[j]).append(" ").append(space);
                        if (counter != 0) {
                            updateLine.append(" ");
                            counter--;
                        }
                    } else
                        updateLine.append(word[j]);
                }
                System.out.println(updateLine);
            } else
                System.out.println(arrayLine[i]);
        }
    }
}