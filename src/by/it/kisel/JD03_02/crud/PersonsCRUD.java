package by.it.kisel.JD03_02.crud;


import by.it.kisel.JD03_02.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonsCRUD {

    public Persons create(Persons persons) throws SQLException {
        persons.setID(0);
        //формирование строки
        // createPersonsSQL по данным bean persons
        String createPersonsSQL = String.format(
                "insert into persons(FirstName,SecondName,PhoneNumber,Email,FK_Role) values('%s','%s','%s','%s',%d);",
                persons.getFirstName(), persons.getSecondName(), persons.getPhoneNumber(), persons.getEmail(), persons.getFK_Role()
        );
        try (
                //создаем соединение и объект для запросов к базе
                Connection connection = ConnectionCreator.getConnection(); //создаем соединение с базой
                Statement statement = connection.createStatement(); //создаем объект для обращения к базе
        ) {
            //выполняем добавление в базу, должна быть добавлена одна запись. Проверим это.
            //create(insert) update delete - это executeUpdate, а select это executeQuery
            if (statement.executeUpdate(createPersonsSQL) == 1) {
                //если все добавлено то узнаем последний ID
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                //извлекаем из resultSet последний ID
                if (resultSet.next())
                    persons.setID(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw e;
        }
        return persons;
    }

    public Persons read(int id) throws SQLException {
        Persons personsResult = null;
        String readPersonsSQL = "SELECT * FROM persons where ID=" + id;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            final ResultSet resultSet = statement.executeQuery(readPersonsSQL);
            if (resultSet.next()) {
                personsResult = new Persons(
                        resultSet.getInt("ID"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("SecondName"),
                        resultSet.getString("PhoneNumber"),
                        resultSet.getString("Email"),
                        resultSet.getInt("FK_Role"));
            }
        } catch (SQLException e) {
            throw e;
        }
        return personsResult;
    }

    public Persons update(Persons persons) throws SQLException {
        Persons personsResult = null;
        String updatePersonsSQL = String.format(
                "UPDATE persons SET FirstName = '%s', SecondName = '%s', PhoneNumber = '%s', Email = '%s', FK_Role=%d WHERE persons.ID = %d",
                persons.getFirstName(), persons.getSecondName(), persons.getPhoneNumber(), persons.getEmail(), persons.getFK_Role(), persons.getID()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            if (statement.executeUpdate(updatePersonsSQL) == 1)
                personsResult = persons;
        } catch (SQLException e) {
            throw e;
        }
        return personsResult;
    }

    public boolean delete(Persons persons) throws SQLException {
        String deletePersonsSQL = String.format("DELETE FROM persons WHERE persons.ID = %d", persons.getID());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            return (statement.executeUpdate(deletePersonsSQL) == 1);
        } catch (SQLException e) {
            throw e;
        }
    }


}
