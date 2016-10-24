package by.it.aborisenok.JD03_02.crud;

import by.it.aborisenok.JD03_02.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Лёша on 21.10.2016.
 */
public class PoliclinicCRUD {
    public Policlinic create(Policlinic policlinic){
        String createPoliclinicSQL = String.format(
                "INSERT INTO policlinic(Name, City, Street, House) " +
                        "values('%s','%s','%s','%d');",
                policlinic.getName(),
                policlinic.getCity(),
                policlinic.getStreet(),
                policlinic.getHouse());
        try {

            Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement();

            if (statement.executeUpdate(createPoliclinicSQL,Statement.RETURN_GENERATED_KEYS) == 1)
            {
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next())
                    policlinic.setID(resultSet.getInt(1));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return policlinic;
    }

    public Policlinic read(int id){
        Policlinic policlinicResult = null;
        String readPoliclinicSQL = "SELECT * FROM policlinic where ID=" + id;
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement())
        {
            final ResultSet resultSet = statement.executeQuery(readPoliclinicSQL);
            if (resultSet.next()) {
                policlinicResult = new Policlinic(resultSet.getInt("ID"),
                        resultSet.getString("Name"),
                        resultSet.getString("City"),
                        resultSet.getString("Street"),
                        resultSet.getInt("House")
                        );

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return policlinicResult;
    }

    public Policlinic update(Policlinic policlinic){
        Policlinic policlinicResult = null;
        String updateDoctorSQL = String.format(
                "UPDATE policlinic SET Name = '%s', " +
                        "City = '%s', " +
                        "Street = '%s', " +
                        "House = '%d'" +
                        " WHERE policlinic.ID = %d",
                policlinic.getName(),
                policlinic.getCity(),
                policlinic.getStreet(),
                policlinic.getHouse(),
                policlinic.getID()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            if (statement.executeUpdate(updateDoctorSQL) == 1)
                policlinicResult = policlinic;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return policlinicResult;
    }

    public boolean delete(Policlinic policlinic){
        boolean result = false;
        String deletePoliclinicSQL = String.format("DELETE FROM policlinic WHERE policlinic.ID = %d", policlinic.getID());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            result = statement.executeUpdate(deletePoliclinicSQL) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
