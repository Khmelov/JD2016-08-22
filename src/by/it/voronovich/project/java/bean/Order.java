package by.it.voronovich.project.java.bean;

import java.io.Serializable;

public class Order implements Serializable{

    private int idShoppingCart;
    private int FK_Users;
    private int FK_Catalog;

    public Order() {

    }

    public Order(int idShoppingCart, int FK_Users, int FK_Catalog) {
        this.idShoppingCart = idShoppingCart;
        this.FK_Users = FK_Users;
        this.FK_Catalog = FK_Catalog;
    }

    @Override
    public int hashCode() {
        int result = idShoppingCart;
        result = 31 * result + FK_Users;
        result = 31 * result + FK_Catalog;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (idShoppingCart != order.idShoppingCart) return false;
        if (FK_Users != order.FK_Users) return false;
        if (FK_Catalog != order.FK_Catalog) return false;

        return true;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idShoppingCart=" + idShoppingCart +
                ", FK_Users='" + FK_Users + '\'' +
                ", FK_Catalog='" + FK_Catalog + '\'' +
                "}\n";
    }

    public int getIdShoppingCart() {
        return idShoppingCart;
    }

    public int getFK_Users() {
        return FK_Users;
    }

    public int getFK_Catalog() {
        return FK_Catalog;
    }

    public void setIdShoppingCart(int idShoppingCart) {
        this.idShoppingCart = idShoppingCart;
    }

    public void setFK_Users(int FK_Users) {
        this.FK_Users = FK_Users;
    }

    public void setFK_Catalog(int FK_Catalog) {
        this.FK_Catalog = FK_Catalog;
    }
}
