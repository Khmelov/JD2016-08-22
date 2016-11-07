package by.it.filimonchik.jd03_02.crud;

import by.it.filimonchik.jd03_02.Connection.ConnectionCreator;
import by.it.filimonchik.jd03_02.bean.Ad;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Raman.Filimonchyk on 07/11/2016.
 */
public class AdCRUD {
    public Ad create(Ad ad) throws SQLException {
        ad.setID(0);
        String createAdSQL = String.format(
                "insert into ad(FK_Model,FK_Car_body,FK_Color,Price,FK_Users) values('%d','%d','%d','%d',%d);",
                ad.getFK_Model(), ad.getFK_Car_body(), ad.getFK_Color(), ad.getPrice(), ad.getFK_Users()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {

            if (statement.executeUpdate(createAdSQL) == 1)
            {
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                if (resultSet.next())
                    ad.setID(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw e;
        }
        return ad;
    }

    public Ad read(int id) throws SQLException {
        Ad adResult = null;
        String readAdSQL = "SELECT * FROM ad where ID=" + id;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            final ResultSet resultSet = statement.executeQuery(readAdSQL);
            if (resultSet.next()) {
                adResult = new Ad(
                        resultSet.getInt("ID"),
                        resultSet.getInt("FK_Model"),
                        resultSet.getInt("FK_Car_body"),
                        resultSet.getInt("FK_Color"),
                        resultSet.getInt("Price"),
                        resultSet.getInt("FK_Users"));

            }
        } catch (SQLException e) {
            throw e;
        }
        return adResult;
    }

    public Ad update(Ad ad) throws SQLException {
        Ad adResult = null;
        String updateAdSQL = String.format(
                "UPDATE ad SET FK_Model = '%d', FK_Car_body = '%d', FK_Color = '%d', Price=%d, FK_Users=%d WHERE ad.ID = %d",
                ad.getFK_Model(), ad.getFK_Car_body(), ad.getFK_Color(), ad.getPrice(),ad.getFK_Users(), ad.getID()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            if (statement.executeUpdate(updateAdSQL) == 1)
                adResult = ad;
        } catch (SQLException e) {
            throw e;
        }
        return adResult;
    }
    public boolean delete(Ad ad) throws SQLException {
        String deleteAdSQL = String.format("DELETE FROM ad WHERE ad.ID = '%d'", ad.getID());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            return (statement.executeUpdate(deleteAdSQL) == 1);

        } catch (SQLException e) {
            throw e;
        }
    }

}
