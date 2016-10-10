package by.it.voronovich.JD02_06.Logger;

import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Logger {

    private static volatile Logger instance;
    private static final String src = System.getProperty("user.dir") + "/src/by/it/voronovich/";
    private static final String filename = src + "jd02_06/Logger/log.txt";

    //конструктор класса
    private Logger() {
    }

    //метод доступа к экземпляру
    public static Logger getInstance() {
        Logger localInstance = instance; //попытка получить объект
        if (localInstance == null) { //первая проверка (для скорости)
            synchronized (Logger.class) {
                localInstance = instance; //вторая проверка для надежности
                if (localInstance == null) {
                    instance = localInstance = new Logger(); //создание
                }
            }
        }
        return localInstance; //возврат
    }

    public static void loggerError(Exception e) {

        FileWriter writer;
        try {
            writer = new FileWriter(filename, true);

            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss", new Locale("ru", "RU"));
            Date date = new Date(System.currentTimeMillis());
            String dateFinal = (dateFormat.format(date));

            String error = String.format("%s   log: %s\n", dateFinal, e.getMessage());

            writer.append(error);
            writer.flush();

        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}





