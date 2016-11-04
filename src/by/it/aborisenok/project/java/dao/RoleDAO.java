package by.it.aborisenok.project.java.dao;


import by.it.aborisenok.project.java.beans.Role;
import by.it.aborisenok.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aborisenok on 26.10.2016.
 */
public class RoleDAO extends AbstractDAO implements InterfaceDAO<Role> {
    @Override
    public Role read(int id) {
        return null;
    }

    @Override
    public boolean create(Role entity) {
        return false;
    }

    @Override
    public boolean update(Role entity) {
        return false;
    }

    @Override
    public boolean delete(Role entity) {
        return false;
    }

    @Override
    public List<Role> getAll(String WHERE) {
        List<Role> roles = new ArrayList<>();
        String sql = "SELECT * FROM role " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Role role = new Role();
                role.setID(rs.getInt("ID"));
                role.setRole(rs.getString("Role"));
                roles.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }
}
