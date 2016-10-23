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
        System.out.println();
        User user = new User("new user", "123", "newuser@mail.ru", 2);
        dao.create(user);
        System.out.println(dao.read(user.getId()));
        user.setLogin("updated");
        dao.update(user);
        System.out.println(dao.read(user.getId()));
        dao.delete(user.getId());
        System.out.println();

        list = dao.getAll();
        for (User u : list) {
            System.out.println(u);
        }
    }
}
