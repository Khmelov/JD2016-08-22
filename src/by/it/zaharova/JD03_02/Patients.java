package by.it.zaharova.JD03_02;

import java.sql.Connection;
import java.sql.Statement;

public class Patients {


    public static void main(String[ ] args) {
        try (Connection connection= ConnectionCreator.getConnection();
             Statement statement=connection.createStatement();) {

            //вставляем пациентов
            statement.executeUpdate(
                    "insert into patients(First_name,Second_name,Address,Phone_number, FK_doctors)"+
                            " values('Dmitriy','Savchuk','Gicalo 15','375294561223',1);"
            );
            statement.executeUpdate(
                    "insert into patients(First_name,Second_name,Address,Phone_number, FK_doctors)"+
                            " values('Kiril','Schasnuy','snov','375294535487861223',2);"
            );
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
