package by.it.grechishnikov.jd03_02.crud;

import static org.junit.Assert.*;
import org.junit.Test;

import java.sql.SQLException;

public class CRUDTests {
    public static User user = new User("vasya333", "333", "123@mail.ru", 2);

    @Test
    public void test01() throws Exception {
        //create user
        CRUDUsers.create(user);
        assertEquals(user.toString(), CRUDUsers.read(user.getId()).toString());
    }

    @Test
    public void test02() throws Exception {
        //read user
        assertEquals(user.toString(), CRUDUsers.read(user.getId()).toString());
    }

    @Test
    public void test03() throws Exception {
        //update user
        user.setPassword("222");
        CRUDUsers.update(user);
        assertEquals(user.toString(), CRUDUsers.read(user.getId()).toString());
    }

    @Test
    public void test04() {
        //delete user
        try {
            CRUDUsers.delete(user.getId());
            assertNotEquals(user.toString(), CRUDUsers.read(user.getId()).toString());
        } catch (NullPointerException e) {
            System.out.println("Объект удален");
        }
    }

    public static Role role = new Role("test");

    @Test
    public void test05() throws Exception {
        //create role
        CRUDRoles.create(role);
        assertEquals(role.toString(), CRUDRoles.read(role.getId()).toString());
    }

    @Test
    public void test06() throws Exception {
        //read role
        assertEquals(role.toString(), CRUDRoles.read(role.getId()).toString());
    }

    @Test
    public void test07() throws Exception {
        //update role
        role.setName("newTest");
        CRUDRoles.update(role);
        assertEquals(role.toString(), CRUDRoles.read(role.getId()).toString());
    }

    public static Goods goods = new Goods("phone", "android", 200);

    @Test
    public void test09() throws Exception {
        //create goods
        CRUDGoods.create(goods);
        assertEquals(goods.toString(), CRUDGoods.read(goods.getId()).toString());
    }

    @Test
    public void test10() throws Exception {
        //read goods
        assertEquals(goods.toString(), CRUDGoods.read(goods.getId()).toString());
    }

    @Test
    public void test11() throws Exception {
        //update goods
        goods.setName("newTest");
        CRUDGoods.update(goods);
        assertEquals(goods.toString(), CRUDGoods.read(goods.getId()).toString());
    }

    @Test
    public void test12() {
        //delete goods
        try {
            CRUDGoods.delete(goods.getId());
            assertNotEquals(goods.toString(), CRUDGoods.read(goods.getId()).toString());
        } catch (NullPointerException e) {
            System.out.println("Объект удален");
        }
    }

    public static Order order = new Order(1, 3);

    @Test
    public void test13() throws Exception {
        //create order
        CRUDOrders.create(order);
        assertEquals(order.toString(), CRUDOrders.read(order.getId()).toString());
    }

    @Test
    public void test14() throws Exception {
        //read order
        assertEquals(order.toString(), CRUDOrders.read(order.getId()).toString());
    }

    @Test
    public void test16() {
        //delete order
        try {
            CRUDOrders.delete(order.getId());
            assertNotEquals(order.toString(), CRUDOrders.read(order.getId()).toString());
        } catch (NullPointerException e) {
            System.out.println("Объект удален");
        }
    }
}
