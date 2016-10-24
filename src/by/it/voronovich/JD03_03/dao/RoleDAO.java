package by.it.voronovich.JD03_03.dao;

import by.it.voronovich.JD03_03.bean.Role;
import by.it.voronovich.JD03_03.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO extends ADAO implements IDAO<Role> {

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
                role.setIdRole(rs.getInt("idRole"));
                role.setName(rs.getString("Name"));
                roles.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

    @Override
    public Role read(int id) {
        List<Role> roles = getAll("WHERE idRole=" + id + " LIMIT 0,1");
        if (roles.size() > 0) {
            return roles.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Role role) {
        String sql = String.format(
                "insert INTO role(Role) values('%s');",role.getName()
        );
        synchronized (RoleDAO.class) {
            role.setIdRole(executeUpdate(sql));
        }
        return (role.getIdRole()>0);
    }

    @Override
    public boolean update(Role role) {
        int resultQuery;
        String sql = String.format(
                "UPDATE `role` SET `Role` = '%s' WHERE `role`.`idRole` = %d",
                role.getName(), role.getIdRole()
        );
        synchronized (RoleDAO.class) {
            resultQuery = executeUpdate(sql);
        }
        return (0 < resultQuery);
    }

    @Override
    public boolean delete(Role role) {
        int resultQuery;
        String sql = String.format(
                "DELETE FROM `role` WHERE `role`.`idRole` = %d;", role.getIdRole()
        );
        synchronized (RoleDAO.class) {
            resultQuery = executeUpdate(sql);
        }
        return (0 < resultQuery);
    }
}