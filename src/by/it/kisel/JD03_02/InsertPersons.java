package by.it.kisel.JD03_02;

import java.sql.Connection;
import java.sql.Statement;

public class InsertPersons {


    public static void main(String[ ] args) {
        try (Connection connection= ConnectionCreator.getConnection();
             Statement statement=connection.createStatement();) {

            //вставляем людей
            statement.executeUpdate(
                    "insert into persons(FirstName,SecondName,PhoneNumber,Email,FK_Role)" +
                            "values('HOTEL','TAVRICHESKAIA','78123266772','tavr@gmail.com', 1);"
            );
            statement.executeUpdate(
                    "insert into persons(FirstName,SecondName,PhoneNumber,Email,FK_Role)\n" +
                            "values('Anna','Korenina','11223344','akor@gmail.com', 2);"
            );
            statement.executeUpdate(
                    "insert into persons(FirstName,SecondName,PhoneNumber,Email,FK_Role)\n" +
                            "values('Alexander','Pushkin','17991837','san9pushk@gmail.com', 2);"
            );
            statement.executeUpdate(
                    "insert into persons(FirstName,SecondName,PhoneNumber,Email,FK_Role)\n" +
                            "values('Evgeny','Onegin','555111333','onejka@gmail.com', 2);"
            );
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
