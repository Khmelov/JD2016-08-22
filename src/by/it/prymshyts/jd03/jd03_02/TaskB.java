package by.it.prymshyts.jd03.jd03_02;

import by.it.prymshyts.jd03.jd03_02.CRUD.*;

import java.sql.SQLException;
import java.util.ArrayList;

class TaskB {
    public static void main(String[] args) {
        UserCRUD userCRUD = new UserCRUD();
        RoleCRUD roleCRUD = new RoleCRUD();

        try {
            ArrayList<User> userList = userCRUD.getAll();

            for (User user : userList) {
                System.out.printf("%-10s (%s)\n", user.getLogin(), roleCRUD.read(user.getFK_Role()).getRole());
            }

            int roleCount = roleCRUD.getAll().size();

            System.out.println("Число пользователей: " + userList.size());
            System.out.println("Число возможных ролей: " + roleCount);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
