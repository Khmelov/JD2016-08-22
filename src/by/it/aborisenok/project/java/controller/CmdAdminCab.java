package by.it.aborisenok.project.java.controller;


import by.it.aborisenok.project.java.beans.*;
import by.it.aborisenok.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Лёша on 08.11.2016.
 */
public class CmdAdminCab extends Action {
    @Override
    Action execute(HttpServletRequest reg) {
        StringBuilder builder = new StringBuilder();


        DAO dao = DAO.getDAO();

        for (User user : dao.user.getAll(""))
        {
            String ID = String.valueOf(user.getID());
            String login = user.getLogin();
            String password = user.getPassword();
            String name = user.getName();
            String surname = user.getSurname();

            String patient = "Логин: " +  login + ", Пароль: " + password + ", Имя: " + name + ", Фамилия: " + surname;


            builder.append("<option value=\""+ ID +"\">"+ patient + "</option>\n");
        }

        reg.setAttribute("message", builder);
        return null;
    }
}
