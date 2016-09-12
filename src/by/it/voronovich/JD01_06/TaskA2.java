package by.it.voronovich.JD01_06;

/**
 * Класс содержит тело метода для решения задачи 2 блока A
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */

public class TaskA2 {

    /**
     * Метод определяет, сколько раз повторяется в тексте каждое слово,
     */
    public static void a2() {

        String text= Data.lukomorie;

        String arrtext[]= text.split("[^а-яА-ЯёЁ]+");

        for (int i = 0; i < arrtext.length; i++) {
            if (arrtext[i].length()>0)
            {
                int count=1;
                for (int j = i+1; j < arrtext.length; j++) {
                    if (arrtext[i].equals(arrtext[j]))
                    {
                        count++;
                        arrtext[j]="";
                    }
                }
                System.out.println("Число повторов слова \""+arrtext[i]+"\" составляет "+count);
            }
        }

    }
}
