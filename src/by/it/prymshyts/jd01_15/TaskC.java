package by.it.prymshyts.jd01_15;

import by.it.prymshyts.jd01_02.Util;

import java.io.File;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC {

    static void t1() {

        String command = "";
        String currentPath = System.getProperty("user.dir");
        File f = new File(currentPath);

        Pattern p  = Pattern.compile("(cd)\\s*(.+)?|(dir)");
        Matcher m;

        while (!command.equals("exit")) {
            System.out.println();
            System.out.print(f.getAbsolutePath() + ">");
            command = Util.getConsoleLine();

            m = p.matcher(command);

            if (m.find()) {
                if (m.group(3) != null && m.group(3).equals("dir")) {
                    dir(f);
                } else if (m.group(1) != null && m.group(1).equals("cd")) {
                    f = cd(f, m.group(2));
                }
            } else if (!command.equals("exit")){
                System.out.println("\"" + command + "\" не является внутренней или внешней\n" +
                        "командой, испольняемой программой или пакетным файлом.");
            }
        }
    }

    private static void dir(File f) {
        File[] files = f.listFiles();

        System.out.println("\n Содержимое папки " + f.getAbsolutePath() + "\n");

        NumberFormat nf = NumberFormat.getNumberInstance();
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy  HH:mm");
        int folderCount = 0, fileCount = 0;
        long fileSize = 0;

        for (File file : files) {

            if (file.isFile()) {
                fileCount++;
                fileSize += file.length();
            } else {
                folderCount++;
            }

            System.out.printf(
                    "%s  %4s  %15s %-10s\n",
                    df.format(new Date(file.lastModified())),
                    (file.isDirectory() ? "<DIR>": "     "),
                    nf.format((file.isDirectory() ? getTotalSize(file) : file.length())),
                    file.getName());
        }

        System.out.printf("%15d %-6s %20s %s\n", fileCount, "файлов", nf.format(fileSize), "байт");
        System.out.printf("%15d %-6s %20s %s\n", folderCount, "папок", nf.format(f.getFreeSpace()), "байт свободно");
    }

    private static File cd(File f, String newPath) {
        if (newPath == null) {
            return f;
        }

        if (newPath.equals("..")) {
            return new File(f.getParent());
        } else {
            File[] files = f.listFiles();
            for (File file : files) {
                if (file.isDirectory() && file.getName().equals(newPath)) {
                    return new File(f.getAbsolutePath() + "/" + newPath);
                }
            }

            System.out.println("Системе не удаётся найти указанный путь.");
            return f;
        }
    }

    private static long getTotalSize(File f) {
        long totalSize = 0;

        File[] files = f.listFiles();

        for (File file : files) {
            if (file.isDirectory()) {
                totalSize += getTotalSize(file);
            } else {
                totalSize += file.length();
            }
        }

        return totalSize;
    }
}
