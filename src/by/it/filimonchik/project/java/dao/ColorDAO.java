package by.it.filimonchik.project.java.dao;

import by.it.filimonchik.project.java.dao.Connection.ConnectionCreator;
import by.it.filimonchik.project.java.bean.Color;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raman.Filimonchyk on 08/11/2016.
 */
    public class ColorDAO extends AbstractDAO implements IDAO<Color> {
        @Override
        public List<Color> getAll(String WHERE) {
            List<Color> colors = new ArrayList<>();
            String sql = "SELECT * FROM color " + WHERE + " ;";
            try (Connection connection = ConnectionCreator.getConnection();
                 Statement statement = connection.createStatement()
            ) {
                ResultSet rs = statement.executeQuery(sql);
                while (rs.next()) {
                    Color color = new Color();
                    color.setID(rs.getInt("ID"));
                    color.setColor(rs.getString("Color"));
                    colors.add(color);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return colors;
        }

        @Override
        public Color read(int id) {
            List<Color> colors = getAll("WHERE ID=" + id + " LIMIT 0,1");
            if (colors.size() > 0) {
                return colors.get(0);
            } else
                return null;
        }

    @Override
    public boolean create(Color entity) {
        return false;
    }

    @Override
    public boolean update(Color entity) {
        return false;
    }

    @Override
    public boolean delete(Color entity) {
        return false;
    }
}
