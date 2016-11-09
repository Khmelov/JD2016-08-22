package by.it.zaharova.JD03_02.crud;


import by.it.zaharova.JD03_02.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DoctorsCRUD {

    public Doctors create(Doctors doctors) throws SQLException {
        doctors.setID(0);
        //формирование строки
        // createDoctorsSQL по данным bean doctors
        String createDoctorsSQL = String.format(
                "insert into doctors(Name_surname,Speciality,Phone_number, Cabinet) values('%s','%s','%s',%s);",
                doctors.getName_surname(), doctors.getSpeciality(),  doctors.getPhone_number(), doctors.getCabinet()
        );
        try (
                //создаем соединение и объект для запросов к базе
                Connection connection = ConnectionCreator.getConnection(); //создаем соединение с базой
                Statement statement = connection.createStatement(); //создаем объект для обращения к базе
        ) {
            //выполняем добавление в базу, должна быть добавлена одна запись. Проверим это.
            //create(insert) update delete - это executeUpdate, а select это executeQuery
            if (statement.executeUpdate(createDoctorsSQL) == 1) {
                //если все добавлено то узнаем последний ID
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                //извлекаем из resultSet последний ID
                if (resultSet.next())
                    doctors.setID(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw e;
        }
        return doctors;
    }

    public Doctors read(int id) throws SQLException {
        Doctors doctorsResult = null;
        String readDoctorsSQL = "SELECT * FROM doctors where ID=" + id;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            final ResultSet resultSet = statement.executeQuery(readDoctorsSQL);
            if (resultSet.next()) {
                doctorsResult = new Doctors(
                        resultSet.getInt("ID"),
                        resultSet.getString("Name_surname"),
                        resultSet.getString("Speciality"),
                        resultSet.getString("Phone_number"),
                        resultSet.getString("Cabinet"));
            }
        } catch (SQLException e) {
            throw e;
        }
        return doctorsResult;
    }

    public Doctors update(Doctors doctors) throws SQLException {
        Doctors doctorsResult = null;
        String updateDoctorsSQL = String.format(
                "UPDATE doctors SET Name_surname = '%s', Speciality = '%s',  Phone_number = '%s', Cabinet=%s WHERE doctors.ID = %d",
                doctors.getName_surname(), doctors.getSpeciality(),  doctors.getPhone_number(), doctors.getCabinet(), doctors.getID()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            if (statement.executeUpdate(updateDoctorsSQL) == 1)
                doctorsResult = doctors;
        } catch (SQLException e) {
            throw e;
        }
        return doctorsResult;
    }

    public boolean delete(Doctors doctors) throws SQLException {
        String deleteDoctorsSQL = String.format("DELETE FROM doctors WHERE doctors.ID = %d", doctors.getID());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            return (statement.executeUpdate(deleteDoctorsSQL) == 1);
        } catch (SQLException e) {
            throw e;
        }
    }


}
