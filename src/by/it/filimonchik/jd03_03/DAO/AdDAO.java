package by.it.filimonchik.jd03_03.DAO;

import by.it.filimonchik.jd03_03.Connection.ConnectionCreator;
import by.it.filimonchik.jd03_03.bean.Ad;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Raman.Filimonchyk on 07/11/2016.
 */
public class AdDAO extends AbstractDAO implements IDAO<Ad> {
    @Override
    public Ad read(int id) {
        List<Ad> roles = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (roles.size() > 0) {
            return roles.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Ad ad) {
        String sql = String.format( Locale.ENGLISH,
                "insert INTO ad(FK_Model,FK_Car_body,FK_Color,Price,FK_Users)" +
                        "\n values('%d', '%d', '%d', '%d', '%d');",
                ad.getFK_Model(),
                ad.getFK_Car_body(),
                ad.getFK_Color(),
                ad.getPrice(),
                ad.getFK_Users()
        );
        ad.setID(executeUpdate(sql));
        return (ad.getID() > 0);
    }

    @Override
    public boolean update(Ad ad) {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `ad` SET " +
                        "`FK_Model`=%d " +
                        ",`FK_Car_body`='%d'" +
                        ",`FK_Color`='%d'" +
                        ",`Price`=%d" +
                        ",`FK_Users`=%d " +
                        " WHERE `ad`.`ID` = %d",
                ad.getFK_Model(),
                ad.getFK_Car_body(),
                ad.getFK_Color(),
                ad.getPrice(),
                ad.getFK_Users(),
                ad.getID()
        );

        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Ad ad) {
        String sql = String.format(
                "DELETE FROM `ad` WHERE `ad`.`ID`=%d;", ad.getID()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<Ad> getAll(String WHERE) {
        List<Ad> ads = new ArrayList<>();
        String sql = "SELECT * FROM ad " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Ad ad = new Ad();
                ad.setID(rs.getInt("ID"));
                ad.setFK_Model(rs.getInt("FK_Model"));
                ad.setFK_Car_body(rs.getInt("FK_Car_body"));
                ad.setFK_Color(rs.getInt("FK_Color"));
                ad.setPrice(rs.getInt("Price"));
                ad.setFK_Users(rs.getInt("FK_Users"));
                ads.add(ad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ads;
    }
}
