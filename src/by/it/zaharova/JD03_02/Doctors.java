package by.it.zaharova.JD03_02;

import java.sql.Connection;
import java.sql.Statement;

public class Doctors {


    public static void main(String[ ] args) {
        try (Connection connection= ConnectionCreator.getConnection();
             Statement statement=connection.createStatement();) {

            //вставляем врачей
            statement.executeUpdate(
                    "insert into doctors(Name_surname,Speciality,Phone_number, Cabinet)"+
                            " values('Vlada Zaharova','surgeon','375293027568',23);"
            );
            statement.executeUpdate(
                    "insert into doctors(Name_surname,Speciality,Phone_number, Cabinet)"+
                            " values('Evgeny Kisel','therapist','375291149845',333);"
            );
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
