package by.it.dubatovka.jd03_03;

import by.it.dubatovka.JD01.jd01_08.old.IBuildOld;
import by.it.dubatovka.jd03_03.beans.Ad;
import by.it.dubatovka.jd03_03.beans.Role;
import by.it.dubatovka.jd03_03.beans.User;
import by.it.dubatovka.jd03_03.dao.AdDAO;
import by.it.dubatovka.jd03_03.dao.DAO;
import by.it.dubatovka.jd03_03.dao.RoleDAO;
import by.it.dubatovka.jd03_03.dao.UserDAO;

import java.util.List;

public class Runner_DAO {
    private static void showUsers() {
        System.out.println("\nТаблица пользователей");
        List<User> list = new UserDAO().getAll("");
        for (User i : list) {
            System.out.print(i);
        }
    }

    private static void showRoles() {
        System.out.println("\nТаблица ролей");
        List<Role> list = new RoleDAO().getAll("");
        for (Role i : list) {
            System.out.print(i);
        }
    }

    private static void showAds() {
        System.out.println("\nСистема заявок");
        List<Ad> list = new AdDAO().getAll("");
        for (Ad i : list) {
            System.out.println(i);
        }
    }




    public static void main(String[] args) {
        CreateDB_dubatovka_helpdesk.createDB();

        DAO dao = DAO.getDAO();
        System.out.println("Роли пользователей:");
        for (Role role : dao.role.getAll("")) {
            System.out.println(role);
        }

        showUsers();
        showRoles();
        showAds();

        Role role=new Role("Менеджер");
        if (dao.role.create(role)) System.out.println("\nДобавлена роль"+role);

        role=new Role("Исполнитель");
        if (dao.role.create(role)) System.out.println("\nДобавлена роль"+role);

        role=new Role("Директор");
        if (dao.role.create(role)) System.out.println("\nДобавлена роль"+role);

        User user = new User("dubatovka", "pass3", "dubatovka@ritzio.com", 2);
        if (dao.user.create(user)) System.out.println("\nДобавлен: " + user);
        showUsers();

        user = new User("shkantou", "duch", "duchtelecom@ritzio.com", 1);
        if (dao.user.create(user)) System.out.println("\nДобавлен: " + user);
        showUsers();

        user = new User("rudevich", "elenaPass", "elena.rudevich@ritzio.com", 3);
        if (dao.user.create(user)) System.out.println("\nДобавлен: " + user);
        showUsers();

        user = new User("TestLogin", "TestPass", "test@ritzio.com", 1);
        if (dao.user.create(user)) System.out.println("\nДобавлен: " + user);
        showUsers();

        user = dao.user.getAll("").get(3);
        user.setEmail("emailUpdateComplete@mail.ru");
        if (dao.user.update(user)) System.out.println("\nИзменен: " + user);
        showUsers();

        if (dao.user.delete(user)) System.out.println("\nУдален: " + user);

    }
}