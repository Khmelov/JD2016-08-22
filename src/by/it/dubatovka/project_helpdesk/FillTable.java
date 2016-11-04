package by.it.dubatovka.project_helpdesk;

import by.it.dubatovka.jd03_01.CN;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class FillTable {
    public static void main(String[] args) {


        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);) {
            Statement statement = connection.createStatement();

            statement.executeUpdate("insert into objects (zia)" + "values('Мнс:Притыцкого')");
            statement.executeUpdate("insert into objects (zia)" + "values('Мнс:Турист')");
            statement.executeUpdate("insert into objects (zia)" + "values('Грд:Клецкова')");
            statement.executeUpdate("insert into objects (zia)" + "values('Лид:Советская')");
            System.out.println("Заполнение таблицы OBJECTS завершено");

            statement.executeUpdate("insert into role (roleName)" + "values('Manager')");
            statement.executeUpdate("insert into role (roleName)" + "values('Worker')");
            statement.executeUpdate("insert into role (roleName)" + "values('Director')");
            System.out.println("Заполнение таблицы ROLE завершено");

            statement.executeUpdate("insert into status (statusName)" + "values('open')");
            statement.executeUpdate("insert into status (statusName)" + "values('in_progress')");
            statement.executeUpdate("insert into status (statusName)" + "values('resolved')");
            System.out.println("Заполнение таблицы STATUS завершено");

            statement.executeUpdate("insert into users (login,password,email,fk_role)" +
                    "values ('dubatovka', 'dubatovka', 'sergej.dubatovka@ritzio.com', 2)");
            statement.executeUpdate("insert into users (login, password, email, fk_role)" +
                    "values ('vorotinskij', 'vorotinskij', 'evgenij.vorotinskij@ritzio.com', 2)");
            statement.executeUpdate("insert into users (login, password, email, fk_role)" +
                    "values ('rudevich', 'rudevich', 'elena.rudevich@ritzio.com', 3)");
            statement.executeUpdate("insert into users (login, password, email, fk_role)" +
                    "values ('grischuk', 'grischuk', 'darya.grischuk@ritzio.com', 1)");
            statement.executeUpdate("insert into users (login, password, email, fk_role)" +
                    "values ('migacheva', 'migacheva', 'kristina.migacheva@ritzio.com', 1)");
            System.out.println("Заполнение таблицы USERS завершено");

            statement.executeUpdate("INSERT INTO priority (priorityName)" + "VALUES ('low')");
            statement.executeUpdate("INSERT INTO priority (priorityName)" + "VALUES ('high')");
            System.out.println("Заполнение таблицы PRIORITY завершено");

            statement.executeUpdate("insert into ad (subject, description, fk_zia, fk_user, fk_status, fk_priority)" +
                    "values('Не работает монитор', 'Не работает нижний монитор на игровом аппарате №2014', 1, 4, 1, 1)");
            statement.executeUpdate("insert into ad (subject, description, fk_zia, fk_user, fk_status, fk_priority)" +
                    "values('Не работает купюроприемник', 'Игровой аппарат №1861 не принимает деньги. Выдает ошибку Bill Acceptor failure', 4, 5, 1, 1)");
            statement.executeUpdate("insert into ad (subject, description, fk_zia, fk_user, fk_status, fk_priority)" +
                    "values('Не работает игровой автомат', 'Выдает ошибку RAM BATTERY LOW', 3, 4, 1, 1)");
            statement.executeUpdate("insert into ad (subject, description, fk_zia, fk_user, fk_status, fk_priority)" +
                    "values('Неисправен кондиционер', 'Кондиционер не охлаждает. Через 5 мин после включения выдает ошибку', 2, 3, 1, 1)");
            statement.executeUpdate("insert into ad (subject, description, fk_zia, fk_user, fk_status, fk_priority)" +
                    "values('СККС для рулетки', 'Необходимо добавить 6 линий к сети СККС для подключения электронной рулетки', 2, 3, 1, 1)");
            statement.executeUpdate("insert into ad (subject, description, fk_zia, fk_user, fk_status, fk_priority)" +
                    "values('Изменение деноминации', 'На аппаратах №6 и №7 установить женоминацию 50руб', 1, 3, 1, 1)");
            System.out.println("Заполнение таблицы AD завершено");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
