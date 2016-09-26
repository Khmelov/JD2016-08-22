package by.it.voronovich.JD01_15;

import java.io.*;

/**
 * Класс демонстрирует ввод-вывод потока данных с его редактированием
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */
public class Task_B1 {

    public static void task_B1(String filename, String filename_out) {

        //Прочитаем тексь прогораммы Task_B1.java и уберем комментарии
        try (BufferedReader bf = new BufferedReader(new FileReader(filename))) {
            StringBuilder sb = new StringBuilder();
            String line = null;
            int num = 0;
            while ((line = bf.readLine()) != null) {
                num++;
                if(num == 25){ // предотвращаем удаление регулярки, к сожалению это частный случай решения и нужно в данном условии учитывать все нюансы в ручную
                    sb.append(String.format("%2d", num) + " " + line + "\n");
                } else {
                    line = line.replaceAll("( \\*{1}.*)|( /.*)|(/\\**)|(/ \\*{1,2}.*)", "");
                    sb.append(String.format("%2d", num) + " " + line + "\n");
                }
                //Импортируем код программы в файл Task_B.txt без комментариев
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename_out))) {
                    bw.write(sb.toString());
                } catch (IOException e) {
                    System.err.println("Ошибка файла...");
                }
            }
            //Распечатаем код программы в консоль без комментариев
            System.out.print(sb);
        } catch (IOException e) {
            System.err.println("Ошибка файла...");
        }
    }
}