package by.it.grechishnikov.jd03_03;

import by.it.grechishnikov.jd03_02.crud.User;
import by.it.grechishnikov.jd03_03.dao.UsersDAO;

import java.util.List;

public class TaskA {
    public static void main(String[] args) {
        UsersDAO dao = new UsersDAO();
        List<User> list = dao.getAll();
        for (User user : list) {
            System.out.println(user);
        }
    }
}
