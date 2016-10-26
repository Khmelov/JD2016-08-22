package by.it.aborisenok.JD03_02.crud;

import by.it.aborisenok.JD03_02.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Лёша on 21.10.2016.
 */
public class UserCRUD {
    public User create(User user){
        user.setID(0);
        String createUserSQL = String.format(
                "INSERT INTO `" + ConnectionCreator.getBdName() + "`.`user`(Login, Password, Name, Surname, BirthDay, City, Street, House, Flat, FK_Role) " +
                        "values('%s','%s', '%s', '%s','" + user.getBirthDay() + "','%s','%s','%d','%d', '%d');",
                user.getLogin(),
                user.getPassword(),
                user.getName(),
                user.getSurname(),
                user.getCity(),
                user.getStreet(),
                user.getHouse(),
                user.getFlat(),
                user.getFK_Role());
        try {

            Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement();

            if (statement.executeUpdate(createUserSQL,Statement.RETURN_GENERATED_KEYS) == 1)
            {
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next())
                    user.setID(resultSet.getInt(1));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }

    public User read(int id){
        User userResult = null;
        String readUserSQL = "SELECT * FROM `" + ConnectionCreator.getBdName() + "`.`user` where ID=" + id;
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement())
        {
            final ResultSet resultSet = statement.executeQuery(readUserSQL);
            if (resultSet.next()) {
                userResult = new User(resultSet.getInt("ID"),
                        resultSet.getString("Login"),
                        resultSet.getString("Password"),
                        resultSet.getString("Name"),
                        resultSet.getString("Surname"),
                        resultSet.getTimestamp("BirthDay"),
                        resultSet.getString("City"),
                        resultSet.getString("Street"),
                        resultSet.getInt("House"),
                        resultSet.getInt("Flat"),
                        resultSet.getInt("FK_Role"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userResult;
    }

    public User update(User user){
        User userResult = null;
        String updateUserSQL = String.format(
                "UPDATE `" + ConnectionCreator.getBdName() + "`.`user` SET Login = '%s'," +
                        "Password = '%s'," +
                        "Name = '%s', " +
                        "Surname = '%s', " +
                        "BirthDay = '" + user.getBirthDay() + "', " +
                        "City = '%s', " +
                        "Street = '%s', " +
                        "House = '%d', " +
                        "Flat = '%d'," +
                        "FK_Role = '%d'"+
                        " WHERE user.ID = %d",
                user.getLogin(),
                user.getPassword(),
                user.getName(),
                user.getSurname(),
                user.getCity(),
                user.getStreet(),
                user.getHouse(),
                user.getFlat(),
                user.getFK_Role(),
                user.getID()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            if (statement.executeUpdate(updateUserSQL) == 1)
                userResult = user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userResult;
    }

    public boolean delete(User user){
        boolean result = false;
        String deleteUserSQL = String.format("DELETE FROM `" + ConnectionCreator.getBdName() + "`.`user` WHERE user.ID = %d", user.getID());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            result = statement.executeUpdate(deleteUserSQL) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
