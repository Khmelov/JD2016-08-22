package by.it.filimonchik.project.java.dao;

import by.it.filimonchik.project.java.dao.Connection.ConnectionCreator;
import by.it.filimonchik.project.java.bean.Ad;

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
                        "\n values('%s', '%s', '%s', '%d', '%d');",
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
                        "`FK_Model`=%s " +
                        ",`FK_Car_body`='%s'" +
                        ",`FK_Color`='%s'" +
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

    public int getCount(String WHERE){
        int res=0;
        String sql = "SELECT Count(*) FROM ad " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)
        ) {
            if (rs.next()) {
                res=(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
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
                ad.setFK_Model(rs.getString("FK_Model"));
                ad.setFK_Car_body(rs.getString("FK_Car_body"));
                ad.setFK_Color(rs.getString("FK_Color"));
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
