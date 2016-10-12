package by.it.prymshyts.matlab;

import java.util.Date;
import java.util.LinkedList;

@SuppressWarnings("ALL")
public class Log {

    private static LinkedList<String> exceptionLog = new LinkedList<>();

    static void println(Object s) {
        if (s != null) {
            System.out.println(s);
        }
    }

    static void print(Object s) {
        if (s != null) {
            System.out.print(s);
        }
    }

    static void printWarning(Object s) {
        System.err.println(s);
    }

    static void logException(String s) {
        StringBuilder sb = new StringBuilder();

        sb.append("-------\n");
        sb.append("Exception #").append(exceptionLog.size() + 1).append("\n");
        sb.append(new Date(System.currentTimeMillis()));
        sb.append(System.lineSeparator());
        sb.append(s);
        sb.append(System.lineSeparator());
        sb.append("-------\n");

        exceptionLog.add(sb.toString());
    }

    static void printExceptionLog() {
        for (String str : exceptionLog) {
            System.err.println(str);
        }
    }
}
