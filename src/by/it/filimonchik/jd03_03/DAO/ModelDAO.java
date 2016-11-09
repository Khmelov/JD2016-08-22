package by.it.filimonchik.jd03_03.DAO;

import by.it.filimonchik.jd03_03.Connection.ConnectionCreator;
import by.it.filimonchik.jd03_03.bean.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raman.Filimonchyk on 08/11/2016.
 */
public class ModelDAO extends AbstractDAO implements IDAO<Model> {
    @Override
    public List<Model> getAll(String WHERE) {
        List<Model> models = new ArrayList<>();
        String sql = "SELECT * FROM model " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Model model = new Model();
                model.setID(rs.getInt("ID"));
                model.setModel(rs.getString("Model"));
                models.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return models;
    }

    @Override
    public Model read(int id) {
        List<Model> models = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (models.size() > 0) {
            return models.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Model entity) {
        return false;
    }

    @Override
    public boolean update(Model entity) {
        return false;
    }

    @Override
    public boolean delete(Model entity) {
        return false;
    }
}