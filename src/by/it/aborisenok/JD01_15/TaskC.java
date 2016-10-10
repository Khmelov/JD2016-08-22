package by.it.aborisenok.JD01_15;

import by.it.akhmelev.jd01_10.matlab_prototype.Patterns;

import java.io.File;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by aborisenok on 06.10.2016.
 */
public class TaskC {

    public static void work(){

        String str = System.getProperty("user.dir");
        File file = new File(str);

        Scanner scanner = new Scanner(System.in);
        String command;
        while (true){
            System.out.print(file.getAbsolutePath() + ">");
            command = scanner.nextLine();
            command.trim();
            if(command.equals("exit")){
                break;
            }
            if (command.startsWith("cd")){
              file = cd(file, command);
            } else
            if (command.startsWith("dir")){
                dir(file);
            } else {
                System.out.println("\"" + command + "\" не является внутренней или внешней\n" +
                        "командой, испольняемой программой или пакетным файлом.");
            }
        }
    }

    private static String makePass(String str){
        String pass = str.replaceFirst("cd", "");
        pass =  pass.trim();
        return pass;
    }


    private static File cd(File file, String str){
        String pass = str;


        if (str.matches("[cd]+ +[\\/]\\w +\\w[:\\\\]+")) {

            char[] chars = pass.toCharArray();
            int passStart = 0;
            for (int i = chars.length-1; i >= 0; i--){
                if (chars[i] == ':'){
                    passStart = i-2;
                    break;
                }
            }
            String newPass = pass.substring(passStart, chars.length);
            newPass = newPass.trim();

            if (new File(newPass).isDirectory())
                file = new File(newPass);
            else {
                file = new File(pass);
            }
        } else


        if (str.matches("cd\\.\\.")){
            pass = file.getAbsolutePath();
            char[] chars = pass.toCharArray();
            for (int i = chars.length-1; i >= 0; i--){
                if (chars[i] != '\\'){
                    chars[i] = ' ';
                } else {
                    if (chars[i-1] != ':')
                          chars[i] = ' ';
                    break;
                }
            }
            String newPass = new String(chars);
            newPass = newPass.trim();
            if (new File(pass).isDirectory())
                file = new File(newPass);
            else {
                file = new File(pass);
            }
        }


        else {
            pass = makePass(pass);
            pass = file.getAbsolutePath() + "\\" + pass;
            if (new File(pass).isDirectory())
                file = new File(pass);
            else {
                System.out.println("Системе не удаётся найти указанный путь.");
            }
        }

        return file;
    }

    private static void dir(File file){
        int fileCount = 0;
        int folderCount = 0;
        long fileSize = 0;
        NumberFormat nf = NumberFormat.getNumberInstance();
        System.out.println("  Содержимое папки " + file.getAbsolutePath());
        for (File files : file.listFiles()){
            if (files.isDirectory()){
               printDir(files);
                folderCount++;
            } else {
                printFile(files);
                fileCount++;
                fileSize += files.length();
            }
        }
        System.out.printf("%15d %-6s %20s %s\n", fileCount, "файлов", nf.format(fileSize), "байт");
        System.out.printf("%15d %-6s %20s %s\n", folderCount, "папок", nf.format(file.getFreeSpace()), "байт свободно");
    }

    private static void printDir(File files){
        Date date = new Date(files.lastModified());
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        System.out.printf("%15s %6s %7s %-15s\n",dateFormat.format(date), "<DIR>", "", files.getName());
    }

    private static void printFile(File files){
        Date date = new Date(files.lastModified());
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        System.out.printf("%15s %6s %7s %-15s\n",dateFormat.format(date), " ", files.length(), files.getName());
    }

}
