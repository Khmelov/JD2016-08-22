package by.it.aborisenok.JD03_03;

import by.it.aborisenok.JD03_03.beans.Role;
import by.it.aborisenok.JD03_03.beans.User;
import by.it.aborisenok.JD03_03.custom_dao.DAO;
import by.it.aborisenok.JD03_03.custom_dao.UserDAO;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by aborisenok on 26.10.2016.
 */
public class CustomRunner {

    static void showUsers(){
        //покажем все, что есть в таблице пользователей
        System.out.println("\nТаблица пользователей:");
        List<User> users=new UserDAO().getAll("");
        for (User each : users) System.out.println(each);
    }

    public static void main(String[] args) {
        //инициализация работы с базой
        DAO dao = DAO.getDAO();
        System.out.println("Роли пользователей");
        for (Role role: dao.role.getAll("")) {
            System.out.println(role);
        }
        showUsers();

        User user = new User(0, "alex", "alex1", "Valera", "Petrov", Timestamp.valueOf("1992-10-06 00:00:00"), "Minsk", "Lenina", 12, 32, 1);
        //добавим пользователя
        if (dao.user.create(user)) System.out.println("\nДобавлен:" + user);
        showUsers();

        //извлечем и обновим пользователя с email siivanov@mail.ru
        user = dao.user.getAll("WHERE ID>2").get(0);
        user.setLogin("up_siivanov");
        if (dao.user.update(user)) System.out.println("\nИзменен:" + user);
        showUsers();

        //удалим пользователя
        if (dao.user.delete(user)) System.out.println("\nУдален:" + user);
        showUsers();

    }
}
