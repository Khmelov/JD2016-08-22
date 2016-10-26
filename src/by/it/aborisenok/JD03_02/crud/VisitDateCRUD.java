package by.it.aborisenok.JD03_02.crud;




import by.it.aborisenok.JD03_02.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Лёша on 21.10.2016.
 */
public class VisitDateCRUD {
    public VisitDate create(VisitDate date){
        date.setID(0);
        String createDateSQL = String.format(
                "INSERT INTO `" + ConnectionCreator.getBdName() + "`.`visitdate` (Time,FK_Doctor) values('"+ date.getVisitTime() +"','%d');",
                 date.getFK_Doctor());
        try {

            Connection connection = ConnectionCreator.getConnection(); //создаем соединение с базой
            Statement statement = connection.createStatement();

            if (statement.executeUpdate(createDateSQL,Statement.RETURN_GENERATED_KEYS) == 1)
            {
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next())
                    date.setID(resultSet.getInt(1));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return date;
    }

    public VisitDate read(int id){
        VisitDate dateResult = null;
        String readDateSQL = "SELECT * FROM `" + ConnectionCreator.getBdName() + "`.`visitdate` where ID=" + id;
        try (Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement())
        {
            final ResultSet resultSet = statement.executeQuery(readDateSQL);
            if (resultSet.next()) {
                dateResult = new VisitDate(resultSet.getInt("ID"),
                                      resultSet.getTimestamp("Time"),
                                      resultSet.getInt("FK_Doctor"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dateResult;
    }

    public VisitDate update(VisitDate date){
        VisitDate dateResult = null;
        String updateDateSQL = String.format(
                "UPDATE `" + ConnectionCreator.getBdName() + "`.`visitdate` SET Time = '"+ date.getVisitTime() +"', FK_Doctor='%d' WHERE visitdate.ID = %d",
                date.getFK_Doctor(), date.getID()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            if (statement.executeUpdate(updateDateSQL) == 1)
                dateResult = date;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dateResult;
    }

    public boolean delete(VisitDate date){
        boolean result = false;
        String deleteDateSQL = String.format("DELETE FROM `" + ConnectionCreator.getBdName() + "`.`visitdate` WHERE visitdate.ID = %d", date.getID());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            result = statement.executeUpdate(deleteDateSQL) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
