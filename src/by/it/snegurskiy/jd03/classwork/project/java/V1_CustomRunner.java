package by.it.snegurskiy.jd03.classwork.project.java;



import by.it.snegurskiy.jd03.classwork.project.java.Bean.Users;
import by.it.snegurskiy.jd03.classwork.project.java.DAO.DAO;
import by.it.snegurskiy.jd03.classwork.project.java.DAO.UserDAO;

import java.sql.SQLException;
import java.util.List;

public class V1_CustomRunner {

    private static void showUsers(){
        //покажем все, что есть в таблице пользователей
        System.out.println("\nТаблица пользователей:");
        List<Users> users=new UserDAO().getAll("");
        for (Users each:users) System.out.println(each);
    }

    public static void main(String[] args) throws SQLException {
        //инициализация работы с базой
        DAO dao = DAO.getDAO();
        System.out.println("Роли пользователей");
        for (by.it.snegurskiy.jd03.classwork.project.java.Bean.Role role: dao.role.getAll("")) {
            System.out.println(role);
        }
        showUsers();

        Users user = new Users(0,"Иванов", "Сергей Иванович", "siivanov", "sdf", 2);
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
