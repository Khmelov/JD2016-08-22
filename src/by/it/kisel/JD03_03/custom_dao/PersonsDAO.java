package by.it.kisel.JD03_03.custom_dao;

import by.it.kisel.JD03_03.beans.Persons;
import by.it.kisel.JD03_03.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonsDAO extends AbstractDAO implements InterfaceDAO<Persons> {
    @Override
    public List<Persons> getAll(String WHERE) {
        List<Persons> personss = new ArrayList<>();
        String sql = "SELECT * FROM persons " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Persons persons = new Persons();
                persons.setID(rs.getInt("ID"));
                persons.setFirstName(rs.getString("FirstName"));
                persons.setSecondName(rs.getString("SecondName"));
                persons.setPhoneNumber(rs.getString("PhoneNumber"));
                persons.setEmail(rs.getString("Email"));
                persons.setFK_Role(rs.getInt("FK_Role"));
                personss.add(persons);
            }
        } catch (SQLException e) {
            //тут нужно логгирование SQLException(e);
        }
        return personss;
    }

    @Override
    public Persons read(int id) {
        List<Persons> persons = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (persons.size() > 0) {
            return persons.get(0);
        } else
            return null;
    }
    @Override
    public boolean create(Persons persons) {
        String sql = String.format(
                "insert INTO persons(FirstName,SecondName,PhoneNumber,Email,FK_Role)" +
                        " values('%s','%s','%s','%s',%d);",
                persons.getFirstName(), persons.getSecondName(), persons.getPhoneNumber(),persons.getEmail(), persons.getFK_Role()
        );
        persons.setID(executeUpdate(sql));
        return (persons.getID()>0);
    }
    @Override
    public boolean update(Persons persons) {
        String sql = String.format(
                "UPDATE `persons` SET `FirstName` = '%s', `SecondName` = '%s', `PhoneNumber` = '%s', `Email` = '%s', `FK_Role` = '%d' WHERE `persons`.`ID` = %d",
                persons.getFirstName(), persons.getSecondName(),persons.getPhoneNumber(), persons.getEmail(), persons.getFK_Role(), persons.getID()
        );
        return (0 < executeUpdate(sql));
    }
    @Override
    public boolean delete(Persons persons) {
        String sql = String.format(
                "DELETE FROM `persons` WHERE `persons`.`ID` = %d;", persons.getID()
        );
        return (0 < executeUpdate(sql));
    }


}
