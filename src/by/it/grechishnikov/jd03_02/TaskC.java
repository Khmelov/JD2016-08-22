package by.it.grechishnikov.jd03_02;

import by.it.grechishnikov.jd03_02.crud.*;

import static by.it.grechishnikov.jd03_01.TaskC.*;

public class TaskC {

    public static void main(String[] args) {
        reset();
    }

    public static void reset() {
        deleteAllTables();
        createAllTables();
        initializeTables();
    }

    private static void deleteAllTables() {
        dropOldDB();
        createNewDB();
    }

    private static void createAllTables() {
        createTables();
    }

    private static void initializeTables() {
        CRUDRoles.create(new Role("admin"));
        CRUDRoles.create(new Role("user"));

        CRUDUsers.create(new User("admin", "admin", "admin@store.by", 1));
        CRUDUsers.create(new User("margo", "123", "margo@mail.ru", 2));
        CRUDUsers.create(new User("robin", "qwerty", "robin@mail.ru", 2));
        CRUDUsers.create(new User("vasya", "333", "vasya@mail.ru", 2));
        CRUDUsers.create(new User("petya", "000000", "petya@mail.ru", 2));
        CRUDUsers.create(new User("dima", "sgiusgso", "dima@mail.ru", 2));

        CRUDGoods.create(new Goods("Beer", "German beer", 3));
        CRUDGoods.create(new Goods("Cola", "Coca cola", 2));
        CRUDGoods.create(new Goods("Chocolate", "Alpen gold", 1));
        CRUDGoods.create(new Goods("Apple", "Red apple", 2));
        CRUDGoods.create(new Goods("T-shirt", "Blue t-shirt", 4));

        CRUDOrders.create(new Order(2, 2));
        CRUDOrders.create(new Order(2, 3));
        CRUDOrders.create(new Order(2, 4));
        CRUDOrders.create(new Order(2, 5));
        CRUDOrders.create(new Order(4, 2));
    }
}
