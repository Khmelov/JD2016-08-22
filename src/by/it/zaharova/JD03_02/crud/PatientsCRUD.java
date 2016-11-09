package by.it.zaharova.JD03_02.crud;


import by.it.zaharova.JD03_02.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PatientsCRUD {

    public Patients create(Patients patients) throws SQLException {
        patients.setID(0);
        //формирование строки
        // createPatientsSQL по данным bean patients
        String createPatientsSQL = String.format(
                "insert into patients(First_name,Second_name,Address,Phone_number, FK_doctors) values('%s','%s','%s','%s',%d);",
                patients.getFirst_name(), patients.getSecond_name(), patients.getAddress(), patients.getPhone_number(), patients.getFK_doctors()
        );
        try (
                //создаем соединение и объект для запросов к базе
                Connection connection = ConnectionCreator.getConnection(); //создаем соединение с базой
                Statement statement = connection.createStatement(); //создаем объект для обращения к базе
        ) {
            //выполняем добавление в базу, должна быть добавлена одна запись. Проверим это.
            //create(insert) update delete - это executeUpdate, а select это executeQuery
            if (statement.executeUpdate(createPatientsSQL) == 1) {
                //если все добавлено то узнаем последний ID
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                //извлекаем из resultSet последний ID
                if (resultSet.next())
                    patients.setID(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw e;
        }
        return patients;
    }

    public Patients read(int id) throws SQLException {
        Patients patientsResult = null;
        String readPatientsSQL = "SELECT * FROM patients where ID=" + id;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            final ResultSet resultSet = statement.executeQuery(readPatientsSQL);
            if (resultSet.next()) {
                patientsResult = new Patients(
                        resultSet.getInt("ID"),
                        resultSet.getString("First_name"),
                        resultSet.getString("Second_name"),
                        resultSet.getString("Address"),
                        resultSet.getString("Phone_number"),
                        resultSet.getInt("FK_doctors"));
            }
        } catch (SQLException e) {
            throw e;
        }
        return patientsResult;
    }

    public Patients update(Patients patients) throws SQLException {
        Patients patientsResult = null;
        String updatePatientsSQL = String.format(
                "UPDATE patients SET First_name = '%s', Second_name = '%s', Address = '%s', Phone_number = '%s', FK_doctors=%d WHERE patients.ID = %d",
                patients.getFirst_name(), patients.getSecond_name(), patients.getAddress(), patients.getPhone_number(), patients.getFK_doctors(), patients.getID()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            if (statement.executeUpdate(updatePatientsSQL) == 1)
                patientsResult = patients;
        } catch (SQLException e) {
            throw e;
        }
        return patientsResult;
    }

    public boolean delete(Patients patients) throws SQLException {
        String deletePatientsSQL = String.format("DELETE FROM patients WHERE patients.ID = %d", patients.getID());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            return (statement.executeUpdate(deletePatientsSQL) == 1);
        } catch (SQLException e) {
            throw e;
        }
    }


}
