package by.it.snegurskiy.jd03.classwork.DAO;

import by.it.snegurskiy.jd03.classwork.Bean.Account;
import by.it.snegurskiy.jd03.classwork.ConnectionCreator;

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
                account.setStatus(rs.getInt("Status"));
                account.setFK_users(rs.getInt("FK_users"));
                account.setFK_roleaccount(rs.getInt("FK_roleaccount"));
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
                "insert into account(Balance, Status,FK_users, FK_roleaccount) values(%d,%d,%d,%d);",
                account.getBalance(),account.getStatus(), account.getFK_users(), account.getFK_roleaccount()
        );
        account.setID(executeUpdate(sql));
        return (account.getID()>0);
    }
    @Override
    public boolean update(Account account) {
        String sql = String.format(
                "UPDATE account SET Balance = %d,Status = %d, FK_users=%d, FK_roleaccount=%d WHERE account.ID=%d",
                account.getBalance(),account.getStatus(), account.getFK_users(), account.getFK_roleaccount(), account.getID()
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

