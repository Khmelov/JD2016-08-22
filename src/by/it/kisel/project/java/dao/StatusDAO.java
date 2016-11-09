package by.it.kisel.project.java.dao;


import by.it.kisel.project.java.beans.Status;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StatusDAO extends AbstractDAO implements InterfaceDAO<Status> {
    @Override
    public List<Status> getAll(String WHERE) {
        List<Status> statuss = new ArrayList<>();
        String sql = "SELECT * FROM status " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Status status = new Status();
                status.setID(rs.getInt("ID"));
                status.setOrderStatus(rs.getString("OrderStatus"));
                status.setFK_orders(rs.getInt("FK_orders"));
                statuss.add(status);
            }
        } catch (SQLException e) {
            //тут нужно логгирование SQLException(e);
        }
        return statuss;
    }

    @Override
    public Status read(int id) {
        List<Status> status = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (status.size() > 0) {
            return status.get(0);
        } else
            return null;
    }
    @Override
    public boolean create(Status status) {
        String sql = String.format(
                "insert INTO status(OrderStatus,FK_orders)" +
                        " values('%s',%d);",
                status.getOrderStatus(), status.getFK_orders()
        );
        status.setID(executeUpdate(sql));
        return (status.getID()>0);
    }
    @Override
    public boolean update(Status status) {
        String sql = String.format(
                "UPDATE `status` SET `OrderStatus` = '%s', `FK_orders` = '%d' WHERE `status`.`ID` = %d",
                status.getOrderStatus(),status.getFK_orders(), status.getID()
        );
        return (0 < executeUpdate(sql));
    }
    @Override
    public boolean delete(Status status) {
        String sql = String.format(
                "DELETE FROM `status` WHERE `status`.`ID` = %d;", status.getID()
        );
        return (0 < executeUpdate(sql));
    }

    public int getCount(String WHERE){
        int res=0;
        String sql = "SELECT Count(*) FROM status " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)
        ) {
            if (rs.next()) {
                res=(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }


}
