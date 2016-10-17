package by.it.akhmelev.jd03_01;

public class CN {
    //Корректно держать настройки соединения вне кода (!)
    //Обычно это файлы конфигурации сервера или фреймворка
    //а сам конфиг в этом случае - bean с инициализацией из XML
    //ТАК ЧТО ЭТО ЛИШЬ ПРИМЕР, ТАК НИКОГДА (!) НЕ ДЕЛАЮТ !
    public static final String URL_DB = "jdbc:mysql://127.0.0.1:2016/it_academy"+
                                        "?useUnicode=true&amp;characterEncoding=UTF-8";
    public static final String USER_DB = "root";
    public static final String PASSWORD_DB = "";
}
