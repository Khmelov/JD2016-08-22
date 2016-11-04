package by.it.shkantau.project.java.dao;


import by.it.shkantau.project.java.beans.Role;
import by.it.shkantau.project.java.connection.ConnectionCreator;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO extends AbstractDAO implements IDAO<Role> {
    @Override
    public List<Role> getAll(String WHERE) {
        List<Role> roles = new ArrayList<>();
        String sql = "SELECT * FROM roles " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Role role = new Role();
                role.setId(rs.getInt("role_id"));
                role.setRole(rs.getString("name"));
                roles.add(role);
            }
        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return roles;
    }

    @Override
    public Role read(int id) {
        List<Role> roles = getAll("WHERE role_id=" + id + " LIMIT 0,1");
        if (roles.size() > 0) {
            return roles.get(0);
        } else
            return null;
    }

    @Override
    public int create(Role role) {
        String sql = String.format(
                "insert INTO roles(name) values('%s',);",role.getRole()
        );
//        role.setId(executeUpdate(sql));
        return executeUpdate(sql);
    }

    @Override
    public boolean update(Role role) {
        String sql = String.format(
                "UPDATE `roles` SET `name` = '%s', WHERE `roles`.`role_id` = %d",
                role.getRole(), role.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Role role) {
        String sql = String.format(
                "DELETE FROM `roles` WHERE `roles`.`role_id` = %d;", role.getId()
        );
        return (0 < executeUpdate(sql));
    }


}
