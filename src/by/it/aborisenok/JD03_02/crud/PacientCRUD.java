package by.it.aborisenok.JD03_02.crud;

import by.it.aborisenok.JD03_02.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Лёша on 21.10.2016.
 */
public class PacientCRUD {
    public Pacient create(Pacient pacient){
        String createPacientSQL = String.format(
                "INSERT INTO pacient(Name, Surname, BirthDay, City, Street, House, Flat, FK_Role) " +
                        "values('%s','%s','" + pacient.getBirthDay() + "','%s','%s', '%d','%d', '%d');",
                pacient.getName(),
                pacient.getSurname(),
                pacient.getCity(),
                pacient.getStreet(),
                pacient.getHouse(),
                pacient.getFlat());
                pacient.getFK_Role();
        try {

            Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement();

            if (statement.executeUpdate(createPacientSQL,Statement.RETURN_GENERATED_KEYS) == 1)
            {
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next())
                    pacient.setID(resultSet.getInt(1));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return pacient;
    }

    public Pacient read(int id){
        Pacient pacientResult = null;
        String readPacientSQL = "SELECT * FROM pacient where ID=" + id;
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement())
        {
            final ResultSet resultSet = statement.executeQuery(readPacientSQL);
            if (resultSet.next()) {
                pacientResult = new Pacient(resultSet.getInt("ID"),
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
        return pacientResult;
    }

    public Pacient update(Pacient pacient){
        Pacient pacientResult = null;
        String updatePacientSQL = String.format(
                "UPDATE pacient SET Name = '%s', " +
                        "Surname = '%s', " +
                        "BirthDay = '" + pacient.getBirthDay() + "', " +
                        "City = '%s', " +
                        "Street = '%s', " +
                        "House = '%d', " +
                        "Flat = '%d'," +
                        "FK_Role = '%d'"+
                        " WHERE pacient.ID = %d",
                pacient.getName(),
                pacient.getSurname(),
                pacient.getCity(),
                pacient.getStreet(),
                pacient.getHouse(),
                pacient.getFlat(),
                pacient.getFK_Role(),
                pacient.getID()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            if (statement.executeUpdate(updatePacientSQL) == 1)
                pacientResult = pacient;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pacientResult;
    }

    public boolean delete(Pacient pacient){
        boolean result = false;
        String deletePacientSQL = String.format("DELETE FROM pacient WHERE pacient.ID = %d", pacient.getID());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            result = statement.executeUpdate(deletePacientSQL) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
