package by.it.snegurskiy.Project.java.DAO;




import by.it.snegurskiy.Project.java.Bean.Userstatus;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserstatusDAO extends AbstractDAO implements InterfaceDAO<Userstatus> {
    @Override
    public List<Userstatus> getAll(String WHERE) {
        List<Userstatus> roles = new ArrayList<>();
        String sql = "SELECT * FROM status " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Userstatus userstatus = new Userstatus();
                userstatus.setId(rs.getInt("ID"));
                userstatus.setStatus(rs.getString("status"));
                roles.add(userstatus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

    @Override
    public Userstatus read(int id) {
        List<Userstatus> roles = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (roles.size() > 0) {
            return roles.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Userstatus role) {
        String sql = String.format(
                "insert INTO role(Role) values('%s',);",role.getStatus()
        );
        role.setId(executeUpdate(sql));
        return (role.getId()>0);
    }

    @Override
    public boolean update(Userstatus role) {
        String sql = String.format(
                "UPDATE `role` SET `Role` = '%s', WHERE `roles`.`ID` = %d",
                role.getStatus(), role.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Userstatus role) {
        String sql = String.format(
                "DELETE FROM `role` WHERE `roles`.`ID` = %d;", role.getId()
        );
        return (0 < executeUpdate(sql));
    }


}

