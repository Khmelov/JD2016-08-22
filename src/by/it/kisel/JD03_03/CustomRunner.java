package by.it.kisel.JD03_03;

import by.it.kisel.JD03_03.beans.Persons;
import by.it.kisel.JD03_03.beans.Role;
import by.it.kisel.JD03_03.custom_dao.DAO;
import by.it.kisel.JD03_03.custom_dao.PersonsDAO;

import java.sql.SQLException;
import java.util.List;

public class CustomRunner {

    static void showUsers(){
        //покажем все, что есть в таблице пользователей
        System.out.println("\nТаблица пользователей:");
        List<Persons> persons=new PersonsDAO().getAll("");
        for (Persons each:persons) System.out.println(each);
    }

    public static void main(String[] args) throws SQLException {
        //инициализация работы с базой
        DAO dao = DAO.getDAO();
        System.out.println("Роли пользователей");
        for (Role role: dao.role.getAll("")) {
            System.out.println(role);
        }
        showUsers();

        Persons persons = new Persons(0,"Евгений","Онегин", "789456123", "oneg@mail.ru",2);
        //добавим пользователя
        if (dao.persons.create(persons)) System.out.println("\nДобавлен:" + persons);
        showUsers();

        //извлечем и обновим пользователя с email siivanov@mail.ru
        persons = dao.persons.getAll("WHERE ID>2").get(0);
        persons.setEmail("oneg@gmail.com");
        if (dao.persons.update(persons)) System.out.println("\nИзменен:" + persons);
        showUsers();

        //удалим пользователя
        if (dao.persons.delete(persons)) System.out.println("\nУдален:" + persons);
        showUsers();
    }
}
