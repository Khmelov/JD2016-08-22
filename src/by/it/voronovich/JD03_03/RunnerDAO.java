package by.it.voronovich.JD03_03;

import by.it.voronovich.JD03_03.bean.Role;
import by.it.voronovich.JD03_03.bean.User;
import by.it.voronovich.JD03_03.dao.DAO;
import by.it.voronovich.JD03_03.dao.UserDAO;

import java.sql.*;
import java.util.List;

public class RunnerDAO {

    static void showUsers(){
        //покажем все, что есть в таблице пользователей
        System.out.println("\nТаблица пользователей:");
        List<User> users=new UserDAO().getAll("");
        for (User each:users) System.out.println(each);
    }

    public static void main(String[] args) throws SQLException {
        //инициализация работы с базой
        DAO dao = DAO.getDAO();
        System.out.println("Роли пользователей");
        for (Role role: dao.getRoleDAO().getAll("")) {
            System.out.println(role);
        }
        showUsers();

        User user = new User(0,"Test", "Test", "Test", "Test", "test@mail.ru",2);
        //добавим пользователя
        if (dao.getUserDAO().create(user)) System.out.println("\nДобавлен:" + user);
        showUsers();

        //извлечем и обновим пользователя с email siivanov@mail.ru
        user = dao.getUserDAO().getAll("WHERE idUsers>4").get(0);
        user.setLogin("new Test");
        if (dao.getUserDAO().update(user)) System.out.println("\nИзменен:" + user);
        showUsers();

        //удалим пользователя
        if (dao.getUserDAO().delete(user)) System.out.println("\nУдален:" + user);
        showUsers();
    }
}