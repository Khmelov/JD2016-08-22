package by.it.prymshyts.jd03.jd03_02.CRUD;

import by.it.prymshyts.jd03.jd03_01.ShowUsers;

import java.sql.SQLException;

class TaskA {
    public static void main(String[] args) {
        UserCRUD userCRUD = new UserCRUD();

        try {
            ShowUsers.showUsers();

            User user = new User(1, "test3@mail.ru", "test3", "test3pass", 2);
            userCRUD.create(user);
            user = userCRUD.read(3);
            System.out.println(user);

            user.setLogin("vasya");

            userCRUD.update(user);
            System.out.println(userCRUD.read(3));

            userCRUD.delete(user);

            ShowUsers.showUsers();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
