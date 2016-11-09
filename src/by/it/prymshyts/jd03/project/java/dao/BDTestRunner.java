package by.it.prymshyts.jd03.project.java.dao;

import by.it.prymshyts.jd03.project.java.beans.Role;
import by.it.prymshyts.jd03.project.java.beans.User;

import java.sql.SQLException;
import java.util.List;

public class BDTestRunner {

    private static void showUsers(){
        System.out.println("\nТаблица пользователей:");

        List<User> users = DAO.getDAO().getUserDAO().getAll();
        for (User each:users) System.out.println(each);
    }

    public static void main(String[] args) throws SQLException {
        DAO dao = DAO.getDAO();
        System.out.println("Роли пользователей");
        for (Role role: dao.getRoleDAO().getAll()) {
            System.out.println(role);
        }
        showUsers();

        User user = new User(0, "siivanov@mail.ru", "Сергей Иванович", "siivanov", 2);

        if (dao.getUserDAO().create(user)) {
            System.out.println("\nДобавлен:" + user);
        }
        showUsers();


        user = dao.getUserDAO().getAll("WHERE ID>2").get(0);
        user.setLogin("up_siivanov");

        if (dao.getUserDAO().update(user)) {
            System.out.println("\nИзменен:" + user);
        }
        showUsers();

        //удалим пользователя
        if (dao.getUserDAO().delete(user)) {
            System.out.println("\nУдален:" + user);
        }
        showUsers();
    }
}
