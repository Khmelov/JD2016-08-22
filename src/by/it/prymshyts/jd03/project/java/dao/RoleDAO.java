package by.it.prymshyts.jd03.project.java.dao;

import by.it.prymshyts.jd03.project.java.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO extends DAO implements InterfaceDAO<Role> {
    @Override
    public Role read(int id) {
        List<Role> roles = getAll("WHERE ID=" + id + " LIMIT 0,1;");
        if (roles.size() > 0) {
            return roles.get(0);
        } else {
            return null;
        }
    }

    @Override
    public boolean create(Role role) {
        String createRoleSQL = String.format(
                "INSERT INTO Role(ID, Role)" +
                        " VALUES(%d, '%s');",
                role.getID(),
                role.getRole());
        return (0 < executeUpdate(createRoleSQL));
    }

    @Override
    public boolean update(Role role) {
        String updateRoleSQL = String.format(
                "UPDATE Role SET Role='%s' WHERE Role.ID=%d;",
                role.getRole(), role.getID());
        return (0 < executeUpdate(updateRoleSQL));
    }

    @Override
    public boolean delete(Role role) {
        String deleteRoleSQL = String.format(
                "DELETE FROM Role WHERE Role.ID=%d", role.getID());
        return (0 < executeUpdate((deleteRoleSQL)));
    }

    @Override
    public List<Role> getAll() {
        return getAll("");
    }

    @Override
    public List<Role> getAll(String condition) {
        List<Role> roles = new ArrayList<>();
        String getAllSQL = "SELECT * FROM Role " + condition + ";";

        try (Connection connection = DB.getConnection();
             Statement statement   = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(getAllSQL);
            while (resultSet.next()) {
                roles.add(new Role(
                        resultSet.getInt("ID"),
                        resultSet.getString("Role")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roles;
    }
}
