package by.it.snegurskiy.jd03.Test;

import by.it.snegurskiy.jd03.classwork.Bean.Account;
import by.it.snegurskiy.jd03.classwork.CRUD.AccountCRUD;

import java.sql.SQLException;

/**
 * Created by Acer on 21.10.2016.
 */
public class Test_account {
    public static void main(String[] args) throws SQLException {
        Account account=new Account(0, 100 , 1, 1, 1);
        AccountCRUD testAccount = new AccountCRUD();
        testAccount.create(account);
        System.out.println(account);
        account.setStatus(2);
        testAccount.update(account);
        account=testAccount.read(account.getID());
        System.out.println(account);
        testAccount.delete(account);

    }
}
