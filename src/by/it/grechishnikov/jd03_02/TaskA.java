package by.it.grechishnikov.jd03_02;

import by.it.grechishnikov.jd03_02.crud.CRUDRoles;
import by.it.grechishnikov.jd03_02.crud.CRUDUsers;
import by.it.grechishnikov.jd03_02.crud.User;

public class TaskA {
    public static void main(String[] args) {
        //Запуск CRUD User
        User user = new User();
        user.setLogin("zhenya");
        user.setPassword("333");
        user.setEmail("123@123");
        user.setRole(2);
        CRUDUsers.create(user);
        System.out.println("Пользователь создан:\n" + user);

        user = CRUDUsers.read(user.getId());
        System.out.println("Пользователь прочитан:\n" + user);

        user.setPassword("111");
        User newUser = CRUDUsers.update(user);
        System.out.println("Пользователь обновлен:\n" + newUser);

        System.out.println("Пользователь удален:\n" + CRUDUsers.delete(user.getId()));

        //Запуск read для role
        System.out.println("Роль с индексом 2: " + CRUDRoles.readRoleByid(2));
        System.out.println("Индекс администратора: " + CRUDRoles.readRoleByName("admin"));
    }
}
