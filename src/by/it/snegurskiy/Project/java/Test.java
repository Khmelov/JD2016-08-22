package by.it.snegurskiy.Project.java;

import by.it.snegurskiy.Project.java.Bean.Account;
import by.it.snegurskiy.Project.java.Bean.Users;
import by.it.snegurskiy.Project.java.DAO.DAO;

import java.util.List;


public class Test {

    public static void main(String[] args) {

        DAO dao = new DAO();
        Account users= (Account) dao.account.getAll("");
        System.out.println(users);




    }
}
