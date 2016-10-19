package by.it.akhmelev.jd03_02;

import by.it.akhmelev.jd03_02.crud.User;
import by.it.akhmelev.jd03_02.crud.UserCRUD;

import java.sql.SQLException;

public class Ex_04_CRUD {
    public static void main(String[] args) {
        User user = new User(0, "login", "pass", "email", 2);
        try {
            //проверка CRUD для пользователей
            UserCRUD userCRUD = new UserCRUD();

            //создание
            user=userCRUD.create(user);

            //чтение
            System.out.print(userCRUD.read(user.getID()));

            //обновление
            user.setLogin("loginUpdate");
            user=userCRUD.update(user);

            System.out.print(userCRUD.read(user.getID()));
            //удаление
            if (userCRUD.delete(user))
                System.out.print("Удален №"+user.getID());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
