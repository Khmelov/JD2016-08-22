package by.it.aborisenok.JD03_03;

import by.it.aborisenok.JD03_03.beans.Role;
import by.it.aborisenok.JD03_03.beans.User;
import by.it.aborisenok.JD03_03.custom_dao.DAO;

import java.sql.Timestamp;

/**
 * Created by Лёша on 03.11.2016.
 */
public class Test {
    public static void main(String[] args) {
        DAO dao = DAO.getDAO();

        User user = new User();
        user.setID(0);
        user.setLogin("Login");
        user.setPassword("Password");
        user.setName("Name");
        user.setSurname("Surname");
        user.setBirthDay(Timestamp.valueOf("1992-09-10" + " 00:00:00"));
        user.setCity("City");
        user.setStreet("Street");
        user.setHouse(Integer.parseInt("12"));
        user.setFlat(Integer.parseInt("8"));
        user.setFK_Role(1);

        System.out.println(user.toString());

        System.out.println(dao.user.create(user));
    }
}
