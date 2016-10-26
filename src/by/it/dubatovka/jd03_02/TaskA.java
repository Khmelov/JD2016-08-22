package by.it.dubatovka.jd03_02;

import by.it.dubatovka.jd03_01.CN;
import by.it.dubatovka.jd03_02.crud.*;


import java.sql.*;

public class TaskA {

    public static void main(String[] args) throws SQLException {

      //  String name="dubatovka";
        try {
            Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM USERS WHERE users.login='dubatovka'");
            while (resultSet.next()) {
                 System.out.println(resultSet.getString("idUser") + ". Login: " + resultSet.getString("login") + ", role: " + resultSet.getString("fk_role"));

                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        User user = new User("test4", "test4", "test4@ritzio.com", 3);
        UserCRUD userCRUD = new UserCRUD();
        userCRUD.create(user);
        System.out.println("Пользователь добавлен: " + '\n' +
                userCRUD.read(user.getIdUser())
        );
        user.setPassword("testUpdatePass");
        User newUser = userCRUD.update(user);
        System.out.println("Пользователь обновлен: " + '\n' +
                userCRUD.read(newUser.getIdUser())
        );
        System.out.println("Пользователь удален: " + '\n' +
                userCRUD.delete(user));


    }

}
