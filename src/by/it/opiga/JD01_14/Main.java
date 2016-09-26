package by.it.opiga.JD01_14;


import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        //Задание А
        String srcFile = System.getProperty("user.dir");
        System.out.println(srcFile);
        String file = srcFile + "\\src\\by\\it\\opiga\\JD01_14\\file.dat";
        File f = new File(file);

        //запись в файл
        try {
            BufferedOutputStream inFile = new BufferedOutputStream(new FileOutputStream(f));
            for (int i = 1; i <= 20; i++) {
                inFile.write(((int) (Math.random() * 10 + 5)));
            }
            inFile.flush();

        } catch (FileNotFoundException e) {
            System.out.println("Файла нет: " + f.getName());
        } catch (IOException e) {
            System.out.println("Конец файла " + e.toString());
        }

        //чтение файла
        int sum = 0;
        int col = 0;
        int i;
        try {
            BufferedInputStream fromFile = new BufferedInputStream(new FileInputStream(file));
            while (fromFile.available() > 0) {
                i = fromFile.read();
//                String si=Integer.toString(i);
//                System.out.println("si= "+si);
                System.out.println("i= " + i);
                col++;
                sum += i;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файла нет: " + f.getName());
        } catch (IOException e) {
            System.out.println("Конец файла " + e.getMessage());
        }
        System.out.println("Сумма чисел= "+sum);
        double avr = ((double)sum / (double)col);
        System.out.println("Среднее = "+avr);

        //Задание B
        String txtfile = srcFile + "\\src\\by\\it\\opiga\\JD01_14\\text.txt";
        File txtFile = new File(txtfile);

        int colWords = 0;
        int colMarks = 0;

        Pattern p1 = Pattern.compile("[:;.,!?]");

        try {
            BufferedReader rtxtfile = new BufferedReader(new InputStreamReader(new FileInputStream(txtFile), "utf-8"));
            while (rtxtfile.ready()) {
                String s = rtxtfile.readLine();
                System.out.println(s);
                Matcher m = p1.matcher(s);
                while (m.find()) {
                    colMarks++;
                }
                String[] words = s.split("[^а-яА-ЯёЁ]+");
                colWords += words.length;
            }
        } catch (IOException e) {
            System.out.println("Конец файла " + e.getMessage());
        }
        System.out.println("Кол-во знаков препинания = "+colMarks+"     Кол-во слов = "+colWords);

        //Задание С
        String src = System.getProperty("user.dir");
        System.out.println(src);
        File f2=new File(src);
        File[]listFiles=f2.listFiles();
        System.out.println("Файлы: ");
        for (int j = 0; j <listFiles.length ; j++) {
            if(listFiles[j].isFile())
            System.out.println(listFiles[j].getName());
        }
        System.out.println("Каталоги: ");
        for (int k = 0; k <listFiles.length ; k++) {
            if(listFiles[k].isDirectory())
                System.out.println(listFiles[k].getName());
        }
    }
}
