package by.it.snegurskiy.Project.java.DAO;



import by.it.snegurskiy.Project.java.Bean.Account;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Acer on 24.10.2016.
 */
public class AccountDAO extends AbstractDAO implements InterfaceDAO<Account> {
    @Override
    public List<Account> getAll(String WHERE) {
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT * FROM account " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Account account = new Account();
                account.setID(rs.getInt("ID"));
                account.setBalance(rs.getInt("Balance"));

                account.setFK_users(rs.getInt("FK_users"));

                accounts.add(account);
            }
        } catch (SQLException e) {
            //тут нужно логгирование SQLException(e);
        }
        return accounts;
    }

    @Override
    public Account read(int id) {
        List<Account> accounts = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (accounts.size() > 0) {
            return accounts.get(0);
        } else
            return null;
    }
    @Override
    public boolean create(Account account) {
        String sql = String.format(
                "insert into account(Balance, FK_users) values(%d,%d);",
                account.getBalance(),account.getFK_users()
        );
        account.setID(executeUpdate(sql));
        return (account.getID()>0);
    }
    @Override
    public boolean update(Account account) {
        String sql = String.format(
                "UPDATE account SET Balance = %d,FK_users=%d WHERE account.ID=%d",
                account.getBalance(), account.getFK_users(), account.getID()
        );
        return (0 < executeUpdate(sql));
    }
    @Override
    public boolean delete(Account account) {
        String sql = String.format(
                "DELETE FROM `users` WHERE `users`.`ID` = %d;", account.getID()
        );
        return (0 < executeUpdate(sql));
    }


}

