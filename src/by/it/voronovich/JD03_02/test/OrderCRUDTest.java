package by.it.voronovich.JD03_02.test;

import by.it.voronovich.JD03_02.bean.Order;
import by.it.voronovich.JD03_02.crud.OrderCRUD;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrderCRUDTest {

    @Test
    public void create() throws Exception {
        int random = (int)(Math.round(Math.random() + 1));
        Order order = new Order(0, random, random);
        OrderCRUD orderCRUD = new OrderCRUD();
        String order1 = orderCRUD.create(order).toString();
        String order2 = orderCRUD.read(order.getIdShoppingCart()).toString();
        assertEquals(order1, order2);
        orderCRUD.delete(order);
    }

    @Test
    public void update() throws Exception {
        int random = (int)(Math.round(Math.random() + 1));
        Order order = new Order(0, random, random);
        OrderCRUD orderCRUD = new OrderCRUD();
        orderCRUD.create(order);
        int random1 = (int)(Math.round(Math.random() + 2));
        order.setFK_Catalog(random1);
        String order1 = orderCRUD.update(order).toString();
        String order2 = orderCRUD.read(order.getIdShoppingCart()).toString();
        assertEquals(order1, order2);
        orderCRUD.delete(order);
    }

    @Test
    public void delete() throws Exception {
        int random = (int)(Math.round(Math.random() + 1));
        Order order = new Order(0, random, random);
        OrderCRUD orderCRUD = new OrderCRUD();
        orderCRUD.create(order);
        boolean order1 = orderCRUD.delete(order);
        boolean order2 = true;
        assertEquals(order1, order2);
    }
}