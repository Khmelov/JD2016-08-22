package by.it.voronovich.JD03_03;

import by.it.voronovich.JD03_03.bean.User;
import by.it.voronovich.JD03_03.un_dao.UniversalDAO;

import java.sql.SQLException;

public class RunnerUniversalDAO {

    public static void main(String[] args) throws SQLException {
        UniversalDAO<User> dao=new UniversalDAO<>(new User(),"users");
        User user=new User(0,"test","test","test", "test", "test", 2);

        dao.create(user);
        System.out.println("Создан: " + user);

        dao.update(user);
        user.setEmail("new test");
        System.out.println("Обновлен: "+user);

        if (dao.delete(user))
            System.out.println("Удален: " + user);

        System.out.println("\nСписок всех записей:");
        for (User current: dao.getAll("")) {
            System.out.println(current);
        }
    }
}
