package by.it.dubatovka.jd03_02.crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class AdCRUD {
    /*
     private int id;
    private String subject;
    private String description;
    private int fk_zia;
    private int fk_status;
    private int fk_user;
    private int fk_priority;
     */
    public Ad create(Ad ad) throws SQLException {
        ad.setId(0);
        String createAdSQL = String.format(
                Locale.ENGLISH, "insert into ad(subject,description,fk_zia,fk_status,fk_user,fk_priority)" +
                        " values('%s','%s','%d','%d','%d','%d');",
                ad.getSubject(),
                ad.getDescription(),
                ad.getFk_zia(),
                ad.getFk_status(),
                ad.getFk_user(),
                ad.getFk_priority());

        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            System.out.println(createAdSQL);
            if (statement.executeUpdate(createAdSQL) == 1) {
                ResultSet resultSet = statement.executeQuery(
                        String.format("SELECT LAST_INSERT_ID();")
                );
                if (resultSet.next()) ad.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw e;
        }
        return ad;
    }


    public Ad read(int id) throws SQLException {
        Ad adResult = null;
        String readAdSQL = "SELECT * FROM ad where ad.idAd=" + id;
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement();) {
            final ResultSet resultSet = statement.executeQuery(readAdSQL);
            if (resultSet.next()) {
                adResult = new Ad(resultSet.getInt("idAd"),
                        resultSet.getString("subject"),
                        resultSet.getString("description"),
                        resultSet.getInt("fk_zia"),
                        resultSet.getInt("fk_status"),
                        resultSet.getInt("fk_user"),
                        resultSet.getInt("fk_priority"));
            }
        } catch (SQLException e) {
            throw e;
        }
        return adResult;
    }

    public Ad update(Ad ad) throws SQLException {
        Ad adResult = null;
        String updateAdSQL = String.format(Locale.ENGLISH, "UPDATE ad " +
                        "SET subject = '%s'," +
                        " description = '%s'," +
                        " fk_zia = '%d'," +
                        " fk_status = '%d'," +
                        " fk_user = '%d'," +
                        " fk_priority = 'd'" +
                        " WHERE ad.idAd='%d'",
                ad.getSubject(),
                ad.getDescription(),
                ad.getFk_zia(),
                ad.getFk_status(),
                ad.getFk_user(),
                ad.getFk_user(),
                ad.getFk_priority());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement();) {
            System.out.println(updateAdSQL);
            if (statement.executeUpdate(updateAdSQL) == 1)
                adResult = ad;
        } catch (SQLException e) {
            throw e;
        }
        return adResult;
    }

    public boolean delete(Ad ad) throws SQLException {
        String deleteAdSQL = String.format("DELETE FROM ad WHERE ad.idAd='%d'", ad.getId());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement();
        ) {
            return (statement.executeUpdate(deleteAdSQL) == 1);
        } catch (SQLException e) {
            throw e;

        }
    }
}