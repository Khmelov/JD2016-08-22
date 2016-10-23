package by.it.voronovich.JD03_03.dao;

import by.it.voronovich.JD03_03.bean.CatalogGood;
import by.it.voronovich.JD03_03.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CatalogGoodDAO extends ADAO implements IDAO<CatalogGood> {

    @Override
    public List<CatalogGood> getAll(String WHERE) {
        List<CatalogGood> cges = new ArrayList<>();
        String sql = "SELECT * FROM catalog " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                CatalogGood cg = new CatalogGood();
                cg.setIdCatalog(rs.getInt("idCatalog"));
                cg.setBrand(rs.getString("Brand"));
                cg.setModel(rs.getString("Model"));
                cg.setPrice(rs.getDouble("Price"));
                cg.setReleaseDate(rs.getString("ReleaseDate"));
                cg.setWeight(rs.getString("Weight"));
                cges.add(cg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cges;
    }

    @Override
    public CatalogGood read(int id) {
        List<CatalogGood> cges = getAll("WHERE idCatalog=" + id + " LIMIT 0,1");
        if (cges.size() > 0) {
            return cges.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(CatalogGood cg) {
        String sql = String.format(
                "insert INTO catalog(Brand,Model,Price,ReleaseDate,Weight) values('%s','%s',%f,'%s','%s');",
                cg.getBrand(), cg.getModel(), cg.getPrice(), cg.getReleaseDate(), cg.getWeight()
        );
        synchronized (CatalogGoodDAO.class){
            cg.setIdCatalog(executeUpdate(sql));
        }
        return (cg.getIdCatalog()>0);
    }

    @Override
    public boolean update(CatalogGood cg) {
        int resultQuery;
        String sql = String.format(
                "UPDATE `catalog` SET `Brand` = '%s',`Model` = '%s',`Price` = %f,`ReleaseDate` = '%s',`Weight` = '%s', WHERE `catalog`.`idCatalog` = %d",
                cg.getBrand(), cg.getModel(), cg.getPrice(), cg.getReleaseDate(), cg.getWeight(), cg.getIdCatalog()
        );
        synchronized (CatalogGoodDAO.class){
            resultQuery = executeUpdate(sql);
        }
        return (0 < resultQuery);
    }

    @Override
    public boolean delete(CatalogGood cg) {
        int resultQuery;
        String sql = String.format(
                "DELETE FROM `catalog` WHERE `catalog`.`idCatalog` = %d;", cg.getIdCatalog()
        );
        synchronized (CatalogGoodDAO.class){
            resultQuery = executeUpdate(sql);
        }
        return (0 < resultQuery);
    }
}

