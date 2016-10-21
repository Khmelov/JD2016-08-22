package by.it.grechishnikov.jd03_02;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskB {
    public static void main(String[] args) {
        //Выводим список всех пользователей на консоль с текстовыми ролями, общим числом пользователей и ролей
        try {
            Statement statement = Connection.startConnection();
            ResultSet set = statement.executeQuery(String.format("select * from users inner join " +
                    "roles on users.FK_Roles=roles.id"));
            while (set.next()) {
                String line = String.format("login = '%s', password = '%s', email = '%s', id = '%d', role = '%s' ",
                        set.getString("login"), set.getString("password"), set.getString("email"),
                        set.getInt("id"), set.getString("name"));
                System.out.println(line);
            }
            //Вывести количество пользователей и ролей
            String lastLine = "Всего пользователей: ";
            set = statement.executeQuery("select count(*) from users");
            set.next();
            lastLine += set.getInt(1);
            set = statement.executeQuery("select count(*) from roles");
            set.next();
            lastLine += ", ролей: " + set.getInt(1);
            System.out.println(lastLine);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connection.closeConnection();
        }
    }
}
