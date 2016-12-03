package by.it.snegurskiy.Project.java.DAO;

import by.it.snegurskiy.Project.java.Bean.Payments;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO extends AbstractDAO implements InterfaceDAO<Payments> {
    @Override
    public List<Payments> getAll(String WHERE) {
        List<Payments> payments = new ArrayList<>();
        String sql = "SELECT * FROM users " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Payments payment = new Payments();
                payment.setID(rs.getInt("ID"));
                payment.setData(rs.getTimestamp("Data"));
                payment.setType(rs.getString("Type"));
                payment.setAmount(rs.getInt("Amount"));
                payment.setSource(rs.getInt("Source"));
                payment.setFK_account(rs.getInt("FK_account"));
                payments.add(payment);
            }
        } catch (SQLException e) {
            //тут нужно логгирование SQLException(e);
        }
        return payments;
    }

    @Override
    public Payments read(int id) {
        List<Payments> payments = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (payments.size() > 0) {
            return payments.get(0);
        } else
            return null;
    }
    @Override
    public boolean create(Payments payment) {
        String sql = String.format(
                "insert into payments (Data, Type, Amount, Source, FK_account) values(%tF,'%s',%d,%d,%d);",
                payment.getData(),payment.getType(),payment.getAmount(), payment.getSource(), payment.getFK_account()
        );
        payment.setID(executeUpdate(sql));
        return (payment.getID()>0);
    }
    @Override
    public boolean update(Payments payments) {
        String sql = String.format(
                "UPDATE payments SET Data = '%tF', Type = '%s', Amount = %d, Source = %d, FK_account=%d WHERE payments.ID = %d",
                payments.getData(),payments.getType(),payments.getAmount(), payments.getSource(), payments.getFK_account(), payments.getID()
        );
        return (0 < executeUpdate(sql));
    }
    @Override
    public boolean delete(Payments payment) {
        String sql = String.format(
                "DELETE FROM `users` WHERE `users`.`ID` = %d;", payment.getID()
        );
        return (0 < executeUpdate(sql));
    }


}
