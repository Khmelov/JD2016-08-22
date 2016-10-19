package by.it.akhmelev.jd03_02;

import java.sql.Connection;
import java.sql.Statement;

public class Ex_01__Rus_Users {


    public static void main(String[ ] args) {
        try (Connection connection=ConnectionCreator.getConnection();
             Statement statement=connection.createStatement();) {

            //вставляем пользователей
            statement.executeUpdate(
                    "insert into users(Login,Password,Email,FK_Role)"+
                            " values('проверка','админ3','admin3@tut.by',1);"
            );
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
