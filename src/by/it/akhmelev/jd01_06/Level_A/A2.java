package by.it.akhmelev.jd01_06.Level_A;

public class A2 {
    public static void main(String[ ] args) {
        //Получим строку в которой лежат слова
        String text=Data.lukomor;
        //переберем все слова и разместим их в массиве.
        //Паттерн для таких слов [а-яА-ЯёЁ]{1,}
        //Следовательно разделитель для таких слов - это все остальное.
        //Поэтому достаточно добавить в паттерн разделителя знак ^ - НЕ.
        String[] mastext= text.split("[^а-яА-ЯёЁ]+");

        for (int i = 0; i < mastext.length; i++) {
            if (mastext[i].length()>0)
                {
                    int count=1;
                    for (int j = i+1; j < mastext.length; j++) {
                        if (mastext[i].equals(mastext[j]))
                        {
                            count++;
                            mastext[j]="";
                        }
                    }
                System.out.println("Число повторов слова \""+mastext[i]+"\" составляет "+count);
                }
        }

    }
}
