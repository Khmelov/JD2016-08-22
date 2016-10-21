package by.it.voronovich.JD03_02;

import by.it.voronovich.JD03_02.bean.CatalogGood;
import by.it.voronovich.JD03_02.bean.Order;
import by.it.voronovich.JD03_02.bean.Role;
import by.it.voronovich.JD03_02.bean.User;
import by.it.voronovich.JD03_02.crud.CatalogGoodCRUD;
import by.it.voronovich.JD03_02.crud.OrderCRUD;
import by.it.voronovich.JD03_02.crud.RoleCRUD;
import by.it.voronovich.JD03_02.crud.UserCRUD;

import java.sql.SQLException;
import java.util.Locale;

import static by.it.voronovich.JD03_02.reset.ResetDB.reset;

public class Runner {

    public static void main(String[] args) {

        //перезапускаем базу данных с исходными данными
        reset();

        Locale.setDefault(new Locale("en_EN"));
        //-----------------------------------------------------------------------------
        User user = new User(0, "test", "test", "test", "test", "test@gmail.com", 2);
        UserCRUD userCRUD = new UserCRUD();
        try {
            //создаем пользователя
            user = userCRUD.create(user);
            //читаем данные пользователя
            user = userCRUD.read(user.getIdUsers());
            System.out.println(user);
            //обновляем данные пользователя
            user.setName("Jack");
            user.setSurname("Jack@gmail.com");
            user = userCRUD.update(user);
            System.out.println(user);
            //удаляем пользователя
            if (userCRUD.delete(user))
                System.out.println("Удален №"+user.getIdUsers());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("");
        //------------------------------------
        Role role = new Role(0, "test");
        RoleCRUD roleCRUD = new RoleCRUD();
        try {
            //создаем роль
            role = roleCRUD.create(role);
            //читаем данные роли
            role = roleCRUD.read(role.getIdRole());
            System.out.println(role);
            //обновляем данные роли
            role.setName("Quest");
            role = roleCRUD.update(role);
            System.out.println(role);
            //удаляем роль
            if (roleCRUD.delete(role))
                System.out.println("Удален №"+role.getIdRole());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("");
        //-----------------------------------------------------------------------------
        CatalogGood cg = new CatalogGood(0, "test", "test", 1.0, "test", "test@gmail.com");
        CatalogGoodCRUD cgCRUD = new CatalogGoodCRUD();
        try {
            //создаем товар
            cg = cgCRUD.create(cg);
            //читаем данные пользователя
            cg = cgCRUD.read(cg.getIdCatalog());
            System.out.println(cg);
            //обновляем данные пользователя
            cg.setBrand("Horizont");
            cg = cgCRUD.update(cg);
            System.out.println(cg);
            //удаляем пользователя
            if (cgCRUD.delete(cg))
                System.out.println("Удален №"+cg.getIdCatalog());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("");
        //------------------------------------
        Order order = new Order(0, 2, 3);
        OrderCRUD orderCRUD = new OrderCRUD();
        try {
            //создаем заказ
            order = orderCRUD.create(order);
            //читаем заказ
            order = orderCRUD.read(order.getIdShoppingCart());
            System.out.println(order);
            //обновляем данные пользователя
            order.setFK_Catalog(1);
            order = orderCRUD.update(order);
            System.out.println(order);
            //удаляем пользователя
            if (orderCRUD.delete(order))
                System.out.println("Удален №"+order.getIdShoppingCart());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("");
    }
}
