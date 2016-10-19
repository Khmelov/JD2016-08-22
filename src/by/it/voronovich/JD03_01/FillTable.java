package by.it.voronovich.JD03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

import static by.it.voronovich.JD03_01.CN.PASSWORD_DB;
import static by.it.voronovich.JD03_01.CN.URL_DB;
import static by.it.voronovich.JD03_01.CN.USER_DB;

public class FillTable {

    public static void main(String[] args) {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
             Statement statement = connection.createStatement();) {
            //Fill table role
            statement.execute("INSERT INTO role (Name) VALUES ('Administrator');");
            statement.execute("INSERT INTO role (Name) VALUES ('User');");

            //Fill table users
            statement.execute("INSERT INTO users (`Name`, `Surname`, `Login`, `Password`, `E-mail`, `FK_Role`) " +
                    " VALUES ('Derek', 'Nicolson', 'der', 'der111' , 'der@gmail.com', 1);");
            statement.execute("INSERT INTO users (`Name`, `Surname`, `Login`, `Password`, `E-mail`, `FK_Role`) " +
                    " VALUES  ('Emmy', 'Toren', 'emm', 'emm111' , 'emm@gmail.com', 2);");
            statement.execute("INSERT INTO users (`Name`, `Surname`, `Login`, `Password`, `E-mail`, `FK_Role`) " +
                    " VALUES ('Tony', 'Demico', 'ton', 'ton111' , 'ton@gmail.com', 2);");
            statement.execute("INSERT INTO users (`Name`, `Surname`, `Login`, `Password`, `E-mail`, `FK_Role`) " +
                    " VALUES ('Piter', 'Griffin', 'pit', 'pit111' , 'pit@gmail.com', 2);");

            //Fill table catalog
            statement.execute("INSERT INTO catalog (`Brand`, `Model`, `Price`, `ReleaseDate`, `Weight`) " +
                    " VALUES ('Atlant', 'GR122114EE', '530.0', '2016 year' , '70 kg');");
            statement.execute("INSERT INTO catalog (`Brand`, `Model`, `Price`, `ReleaseDate`, `Weight`) " +
                    " VALUES ('Atlant', 'DY411114EE', '735.0', '2015 year' , '71 kg');");
            statement.execute("INSERT INTO catalog (`Brand`, `Model`, `Price`, `ReleaseDate`, `Weight`) " +
                    " VALUES ('Samsung', 'ED12', '931.0', '2016 year' , '75 kg');");
            statement.execute("INSERT INTO catalog (`Brand`, `Model`, `Price`, `ReleaseDate`, `Weight`) " +
                    " VALUES ('LG', 'LG7241', '1031.0', '2015 year' , '81 kg');");

            //Fill table shoppingcart
            statement.execute("INSERT INTO shoppingcart (`FK_Users`,`FK_Catalog`) " +
                    " VALUES (2, 3);");
            statement.execute("INSERT INTO shoppingcart (`FK_Users`,`FK_Catalog`) " +
                    " VALUES (3, 1);");
            statement.execute("INSERT INTO shoppingcart (`FK_Users`,`FK_Catalog`) " +
                    " VALUES (4, 2);");
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

