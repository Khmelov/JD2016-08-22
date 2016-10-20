package by.it.grechishnikov.jd03_02.crud;

public class TaskA {
    public static void main(String[] args) {
        //Запуск CRUD User
        User user = new User();
        user.setLogin("zhenya");
        user.setPassword("333");
        user.setEmail("123@123");
        user.setRole(2);
        user.setId(7);
        Users.create(user);
        System.out.println("Пользователь создан:\n" + user);

        user = Users.read(7);
        System.out.println("Пользователь прочитан:\n" + user);

        user.setPassword("111");
        User newUser = Users.update(user);
        System.out.println("Пользователь обновлен:\n" + newUser);

        System.out.println("Пользователь удален:\n" + Users.delete(7));

        //Запуск read для role
        System.out.println(Roles.readRoleByid(2));
        System.out.println(Roles.readRoleByName("admin"));
    }
}
