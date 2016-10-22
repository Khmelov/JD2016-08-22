package by.it.grechishnikov.jd03_03;

import by.it.grechishnikov.jd03_02.crud.Entity;
import by.it.grechishnikov.jd03_02.crud.Goods;
import by.it.grechishnikov.jd03_02.crud.User;
import by.it.grechishnikov.jd03_03.dao.UniversalDAO;

import java.util.ArrayList;
import java.util.List;

public class TaskC {
    public static void main(String[] args) {
        User user = new User("zhenya", "qwerty", "zhenya93@mail.ru", 2);
        UniversalDAO<User> dao = new UniversalDAO<>(user);
        List<Entity> list = new ArrayList<>(dao.getAll());
        for (Entity e : list) {
            System.out.println(e);
        }
        Goods goods = new Goods("test", "test test", 30);
        UniversalDAO<Goods> goodsDAO = new UniversalDAO<>(goods);
        goodsDAO.create();
        System.out.println(goodsDAO.read(goods.getId()));
    }
}
