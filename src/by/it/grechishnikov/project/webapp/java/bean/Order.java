package by.it.grechishnikov.project.webapp.java.bean;

public class Order implements Entity {
    private int id;
    private int user;
    private int goods;

    public Order() {
    }

    public Order(int user, int goods) {
        this.user = user;
        this.goods = goods;
    }

    public Order(int id, int user, int goods) {
        this.id = id;
        this.user = user;
        this.goods = goods;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getGoods() {
        return goods;
    }

    public void setGoods(int goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", goods=" + goods +
                '}';
    }
}
