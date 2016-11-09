package by.it.kisel.project.java.old_demo;

import by.it.kisel.project.java.beans.Role;
import by.it.kisel.project.java.beans.Persons;
import by.it.kisel.project.java.dao.DAO;
import by.it.kisel.project.java.dao.PersonsDAO;

import java.sql.SQLException;
import java.util.List;

public class V1_CustomRunner {

    private static void showPersons(){
        //покажем все, что есть в таблице пользователей
        System.out.println("\nТаблица пользователей:");
        List<Persons> personss=new PersonsDAO().getAll("");
        for (Persons each:personss) System.out.println(each);
    }

    public static void main(String[] args) throws SQLException {
        //инициализация работы с базой
        DAO dao = DAO.getDAO();
        System.out.println("Роли пользователей");
        for (Role role: dao.role.getAll("")) {
            System.out.println(role);
        }
        showPersons();

        Persons persons = new Persons(0,"hhghg", "siivanov","789", "siivanov@mail.ru",2);
        //добавим пользователя
        if (dao.persons.create(persons)) System.out.println("\nДобавлен:" + persons);
        showPersons();

        //извлечем и обновим пользователя с email siivanov@mail.ru
        persons = dao.persons.getAll("WHERE ID>2").get(0);

        if (dao.persons.update(persons)) System.out.println("\nИзменен:" + persons);
        showPersons();

        //удалим пользователя
        if (dao.persons.delete(persons)) System.out.println("\nУдален:" + persons);
        showPersons();
    }
}
