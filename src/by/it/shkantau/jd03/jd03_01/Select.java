package by.it.shkantau.jd03.jd03_01;



import java.sql.*;

public class Select {
    public static void main(String[] args) {


        try(Connection connection = DriverManager.getConnection(ConnectionSettings.URL_DB, ConnectionSettings.USER_DB, ConnectionSettings.PASSWORD_DB);
            Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("select * from users;");
            while (resultSet.next()){
                System.out.println(resultSet.getString(1)+", "+resultSet.getString(2)+", "+ resultSet.getString(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
