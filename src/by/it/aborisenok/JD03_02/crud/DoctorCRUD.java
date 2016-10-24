package by.it.aborisenok.JD03_02.crud;

import by.it.aborisenok.JD03_02.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Лёша on 21.10.2016.
 */
public class DoctorCRUD {
    public Doctor create(Doctor doctor){
        String createDoctorSQL = String.format(
                "INSERT INTO doctor(Name, Surname, Specialization, Category, Cabinet, FK_Policlinic) " +
                        "values('%s','%s','%s','%s','%d','%d');",
                doctor.getName(),
                doctor.getSurname(),
                doctor.getSpecialization(),
                doctor.getCategory(),
                doctor.getCabinet(),
                doctor.getFK_Policlinic());
        try {

            Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement();

            if (statement.executeUpdate(createDoctorSQL,Statement.RETURN_GENERATED_KEYS) == 1)
            {
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next())
                    doctor.setID(resultSet.getInt(1));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return doctor;
    }

    public Doctor read(int id){
        Doctor doctorResult = null;
        String readDoctorSQL = "SELECT * FROM doctor where ID=" + id;
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement())
        {
            final ResultSet resultSet = statement.executeQuery(readDoctorSQL);
            if (resultSet.next()) {
                doctorResult = new Doctor(resultSet.getInt("ID"),
                        resultSet.getString("Name"),
                        resultSet.getString("Surname"),
                        resultSet.getString("Specialization"),
                        resultSet.getString("Category"),
                        resultSet.getInt("Cabinet"),
                        resultSet.getInt("FK_Policlinic"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctorResult;
    }

    public Doctor update(Doctor doctor){
        Doctor doctorResult = null;
        String updateDoctorSQL = String.format(
                "UPDATE doctor SET Name = '%s', " +
                        "Surname = '%s', " +
                        "Specialization = '%s', " +
                        "Category = '%s', " +
                        "Cabinet = '%d', " +
                        "FK_Policlinic = '%d'" +
                        " WHERE doctor.ID = %d",
                doctor.getName(),
                doctor.getSurname(),
                doctor.getSpecialization(),
                doctor.getCategory(),
                doctor.getCabinet(),
                doctor.getFK_Policlinic(),
                doctor.getID()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            if (statement.executeUpdate(updateDoctorSQL) == 1)
                doctorResult = doctor;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctorResult;
    }

    public boolean delete(Doctor doctor){
        boolean result = false;
        String deleteDoctorSQL = String.format("DELETE FROM doctor WHERE doctor.ID = %d", doctor.getID());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            result = statement.executeUpdate(deleteDoctorSQL) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
