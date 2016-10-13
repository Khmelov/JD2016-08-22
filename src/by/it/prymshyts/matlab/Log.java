package by.it.prymshyts.matlab;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@SuppressWarnings("ALL")
public class Log {

    private static final Log instance = new Log();

    private String logname = "log";
    private static File logFile;

    private Log() {
        this.createLogFile();
    }

    static Log getInstance() {
        return instance;
    }

    static Log getInstance(String nameForLog) {
        instance.logname = nameForLog;
        instance.createLogFile();
        return instance;
    }

    static void log(String message) {
        try (FileWriter fileWriter = new FileWriter(logFile, true)) {
            fileWriter.write(getCurrentTime());
            fileWriter.write(System.lineSeparator());
            fileWriter.write("  "+ message);
            fileWriter.write(System.lineSeparator() + System.lineSeparator());
        } catch (IOException e) {
            System.err.println("Ошибка записи в лог файл.");
        }
    }

    static void logException(Exception e) {
        StringBuilder sb = new StringBuilder();

        sb.append("Exception:");
        sb.append(System.lineSeparator());
        sb.append("  ").append(e.getMessage());
        for (StackTraceElement ste : e.getStackTrace()) {
            sb.append("\n  ").append(ste);
        }
        sb.append(System.lineSeparator());

        Log.log(sb.toString());
    }

    private void createLogFile() {
        File logsFolder = new File(System.getProperty("user.dir") + "/src/by/it/prymshyts/matlab/logs");
        if (!logsFolder.exists()) {
            logsFolder.mkdir();
        }

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();

        logname = logname + '-' + dateFormat.format(calendar.getTime()) + ".txt";
        Log.logFile = new File(logsFolder.getAbsolutePath(), logname);

        try {
            if (logFile.createNewFile()) {
                Log.log("Лог создан.");
            }
        } catch (IOException e) {
            System.err.println("Ошибка создания лог файла.");
            System.exit(1);
        }
    }

    static private String getCurrentTime() {
        return "-" + new Date(System.currentTimeMillis()).toString();
    }
}
