package by.it.grechishnikov.jd03_01;

import java.sql.*;

public class TaskC {
    private static Connection connection;
    private static Statement statement;
    static {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/" +
                            "?useUnicode=true&amp;characterEncoding=UTF-8",
                    "root", "");
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        dropOldDB();
        createNewDB();
        createTables();
        inicializeTables();
    }

    public static void dropOldDB() {
        try {
            statement.executeUpdate(String.format("drop database GeneratedStore"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createNewDB() {
        try {
            statement.executeUpdate(String.format("create database GeneratedStore"));
            statement.executeUpdate(String.format("use GeneratedStore"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTables() {
        try {
            statement.executeUpdate(String.format("create table catalog(" +
                    "id int not null primary key auto_increment," +
                    "name varchar(10) not null," +
                    "description varchar(20) not null," +
                    "price int)"));
            statement.executeUpdate(String.format("create table roles(" +
                    "id int not null primary key auto_increment," +
                    "name varchar(10) not null)"));
            statement.executeUpdate(String.format("create table users(" +
                    "id int not null primary key auto_increment," +
                    "login varchar(10) not null," +
                    "password varchar(10) not null," +
                    "email varchar(20) not null," +
                    "FK_Roles int not null," +
                    "FOREIGN KEY (FK_Roles) REFERENCES roles(id))"));
            statement.executeUpdate(String.format("create table orderList(" +
                    "id int not null primary key auto_increment," +
                    "FK_User int not null," +
                    "FK_Goods int not null," +
                    "foreign key (FK_User) references users(id)," +
                    "foreign key (FK_Goods) references catalog(id))"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void inicializeTables() {
        try {
            statement.executeUpdate("insert into roles (name) values('admin')");
            statement.executeUpdate("insert into roles (name) values('user')");

            statement.executeUpdate("INSERT INTO catalog (name, description, price) VALUES ('hairdryer', 'Good hairdryer', '20')");
            statement.executeUpdate("INSERT INTO catalog (name, description, price) VALUES ('sofa', 'Big sofa', '300')");
            statement.executeUpdate("INSERT INTO catalog (name, description, price) VALUES ('phone', 'Android phine', '200')");
            statement.executeUpdate("INSERT INTO catalog (name, description, price) VALUES ('watch', 'Small watch', '50')");
            statement.executeUpdate("INSERT INTO catalog (name, description, price) VALUES ('Suit', 'Nice black suit', '100')");
            statement.executeUpdate("INSERT INTO catalog (name, description, price) VALUES ('Shoes', 'Red shoes', '50')");

            statement.executeUpdate("INSERT INTO users (login, password, email, FK_Roles) VALUES ('admin', 'admin', 'admin@mail.ru', '1')");
            statement.executeUpdate("INSERT INTO users (login, password, email, FK_Roles) VALUES ('vasya', '333', 'vasya@mail.ru', '2')");
            statement.executeUpdate("INSERT INTO users (login, password, email, FK_Roles) VALUES ('petya', 'adbc', 'petya@mail.ru', '2')");
            statement.executeUpdate("INSERT INTO users (login, password, email, FK_Roles) VALUES ('kostya', '123', 'kos@mail.ru', '2')");
            statement.executeUpdate("INSERT INTO users (login, password, email, FK_Roles) VALUES ('vova', 'vov4ik', 'vov4ik@mail.ru', '2')");

            statement.executeUpdate("INSERT INTO orderlist (FK_User, FK_Goods) VALUES ('2', '3')");
            statement.executeUpdate("INSERT INTO orderlist (FK_User, FK_Goods) VALUES ('2', '5')");
            statement.executeUpdate("INSERT INTO orderlist (FK_User, FK_Goods) VALUES ('3', '3')");
            statement.executeUpdate("INSERT INTO orderlist (FK_User, FK_Goods) VALUES ('2', '2')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
