package by.it.shkantau.jd03.jd03_01;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Runner_jd03_01 {

    public static void main(String[] args) {

        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()){

            DbManager.clearTables(statement);
            DbManager.removeTables(statement);

            DbManager.createTables(statement);
            DbManager.fillTables(statement);


            statement.executeUpdate("INSERT INTO users(login,pass,role,email) VALUES('admin','admin', 1,'admin@tut.by')," +
                    "('duch','gfhjkm',1, 'duch@tut.by'),('dispatcher', 'dispatcher', 2,'dispatcher@tut.by')," +
                    "('testUser','000',3 ,'bla@tut.by'),('tesetUser1', '111', 3, 'blabla@tut.by');");


            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            while (resultSet.next()) {
                String out = resultSet.getString("email") + ", " + resultSet.getString("login")+", " + resultSet.getString("role");
                System.out.println(out);
            }

        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
