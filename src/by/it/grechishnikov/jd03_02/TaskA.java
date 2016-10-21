package by.it.grechishnikov.jd03_02;

import by.it.grechishnikov.jd03_02.crud.*;

public class TaskA {
    public static void main(String[] args) {
        //Запуск CRUD User
//        User user = new User("zhenya", "333", "123@123", 2);
//        CRUDUsers.create(user);
//        System.out.println("Пользователь создан:\n" + user);
//
//        user = CRUDUsers.read(user.getId());
//        System.out.println("Пользователь прочитан:\n" + user);
//
//        user.setPassword("111");
//        User newUser = CRUDUsers.update(user);
//        System.out.println("Пользователь обновлен:\n" + newUser);
//
//        System.out.println("Пользователь удален:\n" + CRUDUsers.delete(user.getId()));

        //Запуск CRUD Goods (Catalog)
//        Goods goods = new Goods("fen", "good fen", 200);
//        CRUDGoods.create(goods);
//        System.out.println("Товар создан:\n" + goods);
//
//        goods = CRUDGoods.read(goods.getId());
//        System.out.println("Товар прочитан:\n" + goods);
//
//        goods.setName("newFen");
//        Goods newGoods = CRUDGoods.update(goods);
//        System.out.println("Товар обновлен:\n" + goods);
//
//        System.out.println("Товар удален:\n" + CRUDGoods.delete(goods.getId()));

        //CRUD для roles
//        Role role = new Role("admin");
//        CRUDRoles.create(role);
//        System.out.println("Роль создана:\n" + role);
//
//        role = CRUDRoles.read(role.getId());
//        System.out.println("Роль прочитана:\n" + role);
//
//        role.setName("user");
//        role = CRUDRoles.update(role);
//        System.out.println("Роль обновлена:\n" + role);
//
//        System.out.println("Роль удалена:\n" + CRUDRoles.delete(role.getId()));
//
//        System.out.println("Роль с индексом 2: " + CRUDRoles.read(2));
//        System.out.println("Индекс администратора: " + CRUDRoles.read("admin"));

        //CRUD для orderList
        Order order = new Order(3, 2);
        CRUDOrders.create(order);
        System.out.println("Заказ создан:\n" + order);

        order = CRUDOrders.read(order.getId());
        System.out.println("Заказ прочитан:\n" + order);

        System.out.println("Заказ удален:\n" + CRUDOrders.delete(order.getId()));
    }
}
