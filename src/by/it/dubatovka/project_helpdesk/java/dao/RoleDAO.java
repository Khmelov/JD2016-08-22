package by.it.dubatovka.project_helpdesk.java.dao;

import by.it.dubatovka.project_helpdesk.java.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO extends AbstractDAO implements InterfaceDAO<Role> {

    @Override
    public Role read(int id) {
        List<Role> roles = getAll("WHERE ID=" + id + " LIMIT 0,1;");
        if (roles.size() > 0) return roles.get(0);
        else return null;
    }

    @Override
    public boolean create(Role role) {
        String createRoleSQL = String.format("insert into role(roleName) values ('%s')", role.getRoleName());
        role.setID(executeUpdate(createRoleSQL));
        return (0 > role.getID());
    }

    @Override
    public boolean update(Role role) {
        String updateRoleSQL = String.format("UPDATE role SET zia = '%s' WHERE role.ID='%d'",
                role.getRoleName(), role.getID());
        return (0 < executeUpdate(updateRoleSQL));
    }

    @Override
    public boolean delete(Role role) {
        String deleteRoleSQL = String.format("DELETE FROM role Where role.ID = '%d'", role.getID());
        return (0 < executeUpdate(deleteRoleSQL));
    }

    @Override
    public List<Role> getAll(String WhereAndOrder) {
        List<Role> roles = new ArrayList<>();
        String sql = "SELECT * FROM role " + WhereAndOrder + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Role role = new Role();
                role.setID(resultSet.getInt("ID"));
                role.setRoleName(resultSet.getString("roleName"));
                roles.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }
}
