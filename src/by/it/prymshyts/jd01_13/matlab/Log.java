package by.it.prymshyts.jd01_13.matlab;

import java.util.Date;
import java.util.LinkedList;

public class Log {

    static LinkedList<String> exceptionLog = new LinkedList<>();

    static void println(String s) {
        System.out.println(s);
    }

    static void print(String s) {
        System.out.print(s);
    }

    static void printWarning(String s) {
        System.err.println(s);
    }

    static void logException(String s) {
        StringBuilder sb = new StringBuilder();

        sb.append("-------\n");
        sb.append("Exception #" + (exceptionLog.size() + 1) + "\n");
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
