package by.it.aborisenok.JD03_02.crud;

import by.it.aborisenok.JD03_02.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Лёша on 21.10.2016.
 */
public class TalonCRUD {
    public Talon create(Talon talon){
        talon.setID(0);
        String createTalonSQL = String.format(
                "INSERT INTO `" + ConnectionCreator.getBdName() + "`.`talon` (FK_Policlinic, FK_User, FK_Doctor, FK_VisitDate) " +
                        "values('%d','%d','%d','%d');",
                talon.getFK_Policlinic(),
                talon.getFK_User(),
                talon.getFK_Doctor(),
                talon.getFK_VisitDate());
        try {

            Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement();

            if (statement.executeUpdate(createTalonSQL,Statement.RETURN_GENERATED_KEYS) == 1)
            {
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next())
                    talon.setID(resultSet.getInt(1));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return talon;
    }

    public Talon read(int id){
        Talon talonResult = null;
        String readTalonSQL = "SELECT * FROM `" + ConnectionCreator.getBdName() + "`.`talon` where ID=" + id;
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement())
        {
            final ResultSet resultSet = statement.executeQuery(readTalonSQL);
            if (resultSet.next()) {
                talonResult = new Talon(resultSet.getInt("ID"),
                        resultSet.getInt("FK_Policlinic"),
                        resultSet.getInt("FK_User"),
                        resultSet.getInt("FK_Doctor"),
                        resultSet.getInt("FK_VisitDate")
                );

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return talonResult;
    }

    public Talon update(Talon talon){
        Talon talonResult = null;
        String updateTalonSQL = String.format(
                "UPDATE `" + ConnectionCreator.getBdName() + "`.`talon` SET FK_Policlinic = '%d', " +
                        "FK_User = '%d', " +
                        "FK_Doctor = '%d', " +
                        "FK_VisitDate = '%d'" +
                        " WHERE talon.ID = %d",
                talon.getFK_Policlinic(),
                talon.getFK_User(),
                talon.getFK_VisitDate(),
                talon.getFK_VisitDate(),
                talon.getID()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            if (statement.executeUpdate(updateTalonSQL) == 1)
                talonResult = talon;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return talonResult;
    }

    public boolean delete(Talon talon){
        boolean result = false;
        String deleteTalonSQL = String.format("DELETE FROM `" + ConnectionCreator.getBdName() + "`.`talon` WHERE talon.ID = %d", talon.getID());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            result = statement.executeUpdate(deleteTalonSQL) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
