package by.it.filimonchik.jd03_03.bean;

/**
 * Created by Raman.Filimonchyk on 07/11/2016.
 */
public class Ad {

    private int ID;
    private int FK_Model;
    private int FK_Car_body;
    private int FK_Color;
    private int Price;
    private int FK_Users;

    public Ad() {
    }

    public Ad(int ID, int FK_Model, int FK_Car_body, int FK_Color, int price, int FK_Users) {
        this.ID = ID;
        this.FK_Model = FK_Model;
        this.FK_Car_body = FK_Car_body;
        this.FK_Color = FK_Color;
        Price = price;
        this.FK_Users = FK_Users;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getFK_Model() {
        return FK_Model;
    }

    public void setFK_Model(int FK_Model) {
        this.FK_Model = FK_Model;
    }

    public int getFK_Car_body() {
        return FK_Car_body;
    }

    public void setFK_Car_body(int FK_Car_body) {
        this.FK_Car_body = FK_Car_body;
    }

    public int getFK_Color() {
        return FK_Color;
    }

    public void setFK_Color(int FK_Color) {
        this.FK_Color = FK_Color;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getFK_Users() {
        return FK_Users;
    }

    public void setFK_Users(int FK_Users) {
        this.FK_Users = FK_Users;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "ID=" + ID +
                ", FK_Model=" + FK_Model +
                ", FK_Car_body=" + FK_Car_body +
                ", FK_Color=" + FK_Color +
                ", Price=" + Price +
                ", FK_Users=" + FK_Users +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ad ad = (Ad) o;

        if (ID != ad.ID) return false;
        if (FK_Model != ad.FK_Model) return false;
        if (FK_Car_body != ad.FK_Car_body) return false;
        if (FK_Color != ad.FK_Color) return false;
        if (Price != ad.Price) return false;
        return FK_Users == ad.FK_Users;

    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + FK_Model;
        result = 31 * result + FK_Car_body;
        result = 31 * result + FK_Color;
        result = 31 * result + Price;
        result = 31 * result + FK_Users;
        return result;
    }
}
