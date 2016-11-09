package by.it.shkantau.project.java.dao;

import by.it.shkantau.project.java.beans.Permission;
import by.it.shkantau.project.java.connection.ConnectionCreator;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PermissionDAO extends AbstractDAO implements IDAO<Permission>{

    @Override
    public Permission read(int id) {
        return null;
    }

    @Override
    public int create(Permission entity) {
        return 0;
    }

    @Override
    public boolean update(Permission entity) {
        return false;
    }

    @Override
    public boolean delete(Permission entity) {
        return false;
    }

    @Override
    public List<Permission> getAll(String WhereAndOrder) {
        List<Permission> permissions = new ArrayList<>();
        String sql = "SELECT * FROM permission " + WhereAndOrder + ";";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                permissions.add(new Permission(resultSet.getInt("id_permission"),resultSet.getInt("fk_role")
                        ,resultSet.getInt("fk_command"),resultSet.getBoolean("permission")));
            }

        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return permissions;
    }
}
