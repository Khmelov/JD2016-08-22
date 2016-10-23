package by.it.grechishnikov.jd03_03;

import by.it.grechishnikov.jd03_02.crud.*;
import by.it.grechishnikov.jd03_03.dao.UniversalDAO;

public class TaskC {
    public static void main(String[] args) {
        User user = new User("zhenya", "qwerty", "zhenya93@mail.ru", 2);
        UniversalDAO<User> dao = new UniversalDAO<>(user);
        dao.create();
        dao.read(user.getId());
        dao.update(user);
        dao.delete(user.getId());

        Goods goods = new Goods("test", "test test", 30);
        UniversalDAO<Goods> goodsDAO = new UniversalDAO<>(goods);
        goodsDAO.create();
        goodsDAO.read(goods.getId());
        goodsDAO.update(goods);
        goodsDAO.delete(goods.getId());

        Role role = new Role("test");
        UniversalDAO<Role> roleDAO = new UniversalDAO<>(role);
        roleDAO.create();
        roleDAO.read(role.getId());
        roleDAO.update(role);
        roleDAO.delete(role.getId());

        Order order = new Order(1, 1);
        UniversalDAO<Order> orderDAO = new UniversalDAO<>(order);
        orderDAO.create();
        orderDAO.read(order.getId());
        orderDAO.update(order);
        orderDAO.delete(order.getId());
    }
}
