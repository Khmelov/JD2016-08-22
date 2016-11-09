package by.it.shkantau.jd03.jd03_03.dao;

import by.it.shkantau.jd03.jd03_03.beans.Role;
import by.it.shkantau.jd03.jd03_03.connection.ConnectionCreator;

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
        String sql = "SELECT * FROM role " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Role role = new Role();
                role.setId(rs.getInt("role_id"));
                role.setRole(rs.getString("role"));
                roles.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
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
                "insert INTO role(Role) values('%s',);",role.getRole()
        );
//        role.setId(executeUpdate(sql));
        return executeUpdate(sql);
    }

    @Override
    public boolean update(Role role) {
        String sql = String.format(
                "UPDATE `role` SET `Role` = '%s', WHERE `roles`.`role_id` = %d",
                role.getRole(), role.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Role role) {
        String sql = String.format(
                "DELETE FROM `role` WHERE `roles`.`role_id` = %d;", role.getId()
        );
        return (0 < executeUpdate(sql));
    }


}
