package by.it.opiga.JD03_01;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by Asus on 21.10.2016.
 */
public class FillDbOrders {
    private static long unixTime;
    private static String dropTableRole = String.format(Locale.ENGLISH, "DROP TABLE IF EXISTS t01_role;");
    private static String dropTableUser = String.format(Locale.ENGLISH, "DROP TABLE IF EXISTS t02_user;");
    private static String dropTableOrder = String.format(Locale.ENGLISH, "DROP TABLE IF EXISTS t03_order;");
    private static String dropTableStatus = String.format(Locale.ENGLISH, "DROP TABLE IF EXISTS t04_status;");
    private static String createTableRole = String.format(Locale.ENGLISH,
            "CREATE TABLE  t01_role("
                    + "ID int not null AUTO_INCREMENT,"
                    + "role varchar(20) not null,"
                    + "PRIMARY KEY (ID));");
    private static String createTableUser = String.format(Locale.ENGLISH,
            "CREATE TABLE  t02_user("
                    + "ID int not null AUTO_INCREMENT,"
                    + "login varchar(20) not null,"
                    + "pass varchar(20) not null,"
                    + "email varchar(20) not null,"
                    + "FK_role int(10) not null,"
                    + "FOREIGN KEY (FK_role) REFERENCES t01_role(ID),"
                    + "PRIMARY KEY (ID));");
    private static String createTableOrder = String.format(Locale.ENGLISH,
            "CREATE TABLE  t03_order("
                    + "ID int not null AUTO_INCREMENT,"
                    + "fio varchar(20) not null,"
                    + "passport varchar(20) not null,"
                    + "phone int(15) not null,"
                    + "category varchar(20) not null,"
                    + "arrive bigint(20) not null,"
                    + "leavee bigint(20) not null,"
                    + "payment varchar(20) not null,"
                    + "FK_user int not null,"
                    + "FK_status int not null,"
                    + "FOREIGN KEY (FK_user) REFERENCES t02_user(ID),"
                    + "FOREIGN KEY (FK_status) REFERENCES t04_status(ID),"
                    + "PRIMARY KEY (ID));");
    private static String createTableStatus = String.format(Locale.ENGLISH,
            "CREATE TABLE  t04_status("
                    + "ID int not null AUTO_INCREMENT,"
                    + "status varchar(20) not null,"
                    + "PRIMARY KEY (ID));");
    private static String insertIntoRoleUser = String.format(Locale.ENGLISH,
            "insert into t01_role (role)"
                    + "values ('user');");
    private static String insertIntoRoleAdmin = String.format(Locale.ENGLISH,
            "insert into t01_role (role)"
                    + "values ('admin');");
    private static String insertIntoUser = String.format(Locale.ENGLISH,
            "insert into t02_user (login,pass,email,FK_role)"
                    + "values ('pavel','123','pavel@mail.ru','2');");
    private static String insertIntoOrder = String.format(Locale.ENGLISH,
            "insert into t03_order (fio,passport,phone,category,arrive,leavee,payment,FK_user,FK_status)"
                    + "values ('pavlov','MP2563985','368978','lux'," +
                    getCurrentTimeStamp() + "," + getTimeLeave() + ",'cash','1','1');");
    private static String insertIntoStatus1 = String.format(Locale.ENGLISH,
            "insert into t04_status (status)"
                    + "values ('consider');");
    private static String insertIntoStatus2 = String.format(Locale.ENGLISH,
            "insert into t04_status (status)"
                    + "values ('accepted');");

    public static void createTable() {
        try (Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement();) {
//            statement.execute(dropTableStatus);
//            statement.execute(dropTableRole);
//            statement.execute(dropTableUser);
//            statement.execute(dropTableOrder);
            statement.execute(createTableStatus);

            statement.execute(createTableRole);

            statement.execute(createTableUser);

            statement.executeUpdate(createTableOrder);

            statement.execute(insertIntoStatus1);
            statement.execute(insertIntoStatus2);
            statement.execute(insertIntoRoleUser);
            statement.execute(insertIntoRoleAdmin);
            statement.execute(insertIntoUser);
            statement.execute(insertIntoOrder);

            System.out.println("тaблицы созданы");

            statement.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public static void main(String[] args) {
        createTable();
        //System.out.println(getCurrentTimeStamp());
    }

    //метод возвращает текущую дату и время:
    private static long getCurrentTimeStamp() {

        //Ну, во-первых, не 4 разряда, а три. А во-вторых, в Java время считается с 1 января 1970 года GMT в миллисекундах, а не в секундах. Отсюда и три разряда.
        unixTime = System.currentTimeMillis();
//        System.out.println(unixTime);
//        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
//        Date resultdate = new Date(unixTime);
//        System.out.println(sdf.format(resultdate));
        return unixTime;
    }

    private static long getTimeLeave() {
        long timeleave = unixTime + 15552000 * 20;
//        System.out.println(unixTime);
//        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
//        Date resultdate = new Date(timeleave);
//        System.out.println(sdf.format(resultdate));
        return timeleave;
    }
}

