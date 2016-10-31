package by.it.dubatovka.project_helpdesk.java.dao;


import by.it.dubatovka.project_helpdesk.java.beans.Ad;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AdDAO extends AbstractDAO implements InterfaceDAO<Ad> {

    @Override
    public Ad read(int id) {
        List<Ad> ads = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (ads.size() > 0) {
            return ads.get(0);
        } else return null;
    }

    @Override
    public boolean create(Ad ad) {
        String sql = String.format("INSERT INTO ad (subject,description,fk_zia,fk_status,fk_user,fk_priority)" +
                        "values ('%s','%s','%d','%d','%d','%d')",
                ad.getSubject(),
                ad.getDescription(),
                ad.getFk_zia(),
                ad.getFk_status(),
                ad.getFk_user(),
                ad.getFk_priority());
        ad.setId(executeUpdate(sql));
        return (ad.getId() > 0);
    }

    @Override
    public boolean update(Ad ad) {
        String sql = String.format(Locale.ENGLISH, "UPDATE ad " +
                        "SET subject = '%s'," +
                        " description = '%s'," +
                        " fk_zia = '%d'," +
                        " fk_status = '%d'," +
                        " fk_user = '%d'," +
                        " fk_priority = 'd'" +
                        " WHERE ad.ID='%d'",
                ad.getSubject(),
                ad.getDescription(),
                ad.getFk_zia(),
                ad.getFk_status(),
                ad.getFk_user(),
                ad.getFk_user(),
                ad.getFk_priority());

        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Ad ad) {
        String sql = String.format("DELETE FROM ad WHERE ad.ID='%d'", ad.getId());
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<Ad> getAll(String WHERE) {
        List<Ad> ads = new ArrayList<>();
        String sql = "SELECT * FROM ad " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Ad ad = new Ad();
                ad.setId(resultSet.getInt("ID"));
                ad.setSubject(resultSet.getString("subject"));
                ad.setDescription(resultSet.getString("description"));
                ad.setFk_zia(resultSet.getInt("fk_zia"));
                ad.setFk_status(resultSet.getInt("fk_status"));
                ad.setFk_user(resultSet.getInt("fk_user"));
                ad.setFk_priority(resultSet.getInt("fk_priority"));
                ads.add(ad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ads;
    }
}
