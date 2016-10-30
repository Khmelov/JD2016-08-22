package by.it.opiga.JD03_03;

import by.it.opiga.JD03_03.beans.Role;
import by.it.opiga.JD03_03.beans.User;
import by.it.opiga.JD03_03.dao.DAO;
import by.it.opiga.JD03_03.dao.UserDAO;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Asus on 28.10.2016.
 */
public class TaskA {
    static void showUsers(){
        System.out.println("\n Таблица пользователей:");
        List<User> users=new UserDAO().getAll("");
        for (User each:users) System.out.println(each);
    }

    public static void main(String[] args) throws SQLException {
        //инициализация работы с базой
        DAO dao = DAO.getDAO();
        System.out.println("Роли пользователей");
        for (Role role: dao.role.getAll("")) {
            System.out.println(role);
        }
        showUsers();

        User user = new User(0,"petrov", "pass458", "petrov@mail.ru",2);
        //добавим пользователя
        if (dao.user.create(user)) System.out.println("\nДобавлен:" + user);
        showUsers();

        //извлечем и обновим пользователя
        user = dao.user.getAll("WHERE ID>1").get(0);
        user.setLogin("petrovich");
        if (dao.user.update(user)) System.out.println("\nИзменен:" + user);
        showUsers();

        //удалим пользователя
        if (dao.user.delete(user)) System.out.println("\nУдален:" + user);
        showUsers();
    }


}
