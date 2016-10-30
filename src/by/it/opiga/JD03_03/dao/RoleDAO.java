package by.it.opiga.JD03_03.dao;

import by.it.opiga.JD03_03.beans.Role;
import by.it.opiga.JD03_04.project.java.dao.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Asus on 28.10.2016.
 */
public class RoleDAO extends DAO implements InterfaceDAO<Role> {
    @Override
    public Role read(int id) {
        List<Role> roles = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (roles.size() > 0) {
            return roles.get(0);
        }
        return null;
    }

    @Override
    public boolean create(Role role) {
        String sql = String.format("insert INTO t01_role(ID,role)" +
                        " values('%d','%s');",
                role.getID(), role.getRole());
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean update(Role role) {
        String sql = String.format("UPDATE 't01_role'" +
                        "SET 'role'='%s'" +
                        " WHERE id='%d';)",
                role.getRole(), role.getID());
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Role role) {
        String sql = String.format("DELETE FROM 't01_role' WHERE 't01_role'.ID='%d';",
                role.getID());
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<Role> getAll(String WhereAndOrder) {
        List<Role> roles = new ArrayList<>();
        String sql = String.format(Locale.ENGLISH,"SELECT * FROM t01_role " + WhereAndOrder + " ;");
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement();) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Role role = new Role();
                role.setID(resultSet.getInt("ID"));
                role.setRole(resultSet.getString("role"));
                roles.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }
}
