package by.it.snegurskiy.Project.java;




import by.it.snegurskiy.Project.java.Bean.Account;
import by.it.snegurskiy.Project.java.Bean.Role;
import by.it.snegurskiy.Project.java.Bean.Users;
import by.it.snegurskiy.Project.java.DAO.DAO;
import by.it.snegurskiy.Project.java.DAO.UserDAO;

import java.sql.SQLException;
import java.util.List;

public class V1_CustomRunner {


    public static void main(String[] args) throws SQLException {
        //инициализация работы с базой
        DAO dao = DAO.getDAO();
        List<Account> account = dao.account.getAll("");
        System.out.println(account.get(0));
    }
}
