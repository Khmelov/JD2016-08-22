package by.it.prymshyts.jd03.jd03_01.DB_Test_Creation;

import by.it.prymshyts.jd03.DB;

import java.sql.Connection;
import java.sql.Statement;

class TestTableCreation implements DB_TEST_COMMANDS {

    // Удалить таблицу ролей.
    private static final boolean DROP_ROLE = true;
    // Удалить таблицу пользователей.
    private static final boolean DROP_USERS = true;
    // Удалить таблицу статей.
    private static final boolean DROP_ARTICLE = true;

    // Создать таблицу ролей.
    private static final boolean CREATE_ROLE = true;
    // Создать таблицу пользователей.
    private static final boolean CREATE_USERS = true;
    // Создать таблицу статей.
    private static final boolean CREATE_ARTICLE = true;

    // Обновить таблицу ролей.
    private static final boolean UPDATE_ROLE = true;
    // Обновить таблицу пользователей.
    private static final boolean UPDATE_USERS = true;
    // Обновить таблицу статей.
    private static final boolean UPDATE_ARTICLE = true;


    public static void main(String[] args) {
        try (Connection connection = DB.getConnection();
             Statement statement = connection.createStatement()) {
            if (!connection.isClosed()) {

                statement.execute(FK_CHECK_OFF);

                if (DROP_ROLE) {
                    statement.executeUpdate(DROP_TABLE_ROLE);
                    System.out.println("Таблица ролей удалена");
                }
                if (DROP_USERS) {
                    statement.executeUpdate(DROP_TABLE_USERS);
                    System.out.println("Таблица пользователей удалена");
                }
                if (DROP_ARTICLE) {
                    statement.executeUpdate(DROP_TABLE_ARTICLE);
                    System.out.println("Таблица статей удалена");
                }

                if (CREATE_ROLE) {
                    statement.executeUpdate(CREATE_TABLE_ROLE);
                    System.out.println("Таблица ролей создана");
                }
                if (CREATE_USERS) {
                    statement.executeUpdate(CREATE_TABLE_USERS);
                    System.out.println("Таблица пользователей создана");
                }
                if (CREATE_ARTICLE) {
                    statement.executeUpdate(CREATE_TABLE_ARTICLE);
                    System.out.println("Таблица статей создана");
                }

                if (UPDATE_ROLE) {
                    statement.executeUpdate(UPDATE_TABLE_ROLE_1);
                    statement.executeUpdate(UPDATE_TABLE_ROLE_2);
                    System.out.println("Таблица ролей заполнена");
                }
                if (UPDATE_USERS) {
                    statement.executeUpdate(UPDATE_TABLE_USERS_1);
                    statement.executeUpdate(UPDATE_TABLE_USERS_2);
                    System.out.println("Таблица пользователей заполнена");
                }
                if (UPDATE_ARTICLE) {
                    statement.executeUpdate(UPDATE_TABLE_ARTICLE);
                    System.out.println("Таблица статей заполнена");
                }

                statement.execute(FK_CHECK_ON);

            } else {
                System.out.println("Соединениес БД не было установлено");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
