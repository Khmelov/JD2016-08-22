package by.it.filimonchik.project.java.bean;

/**
 * Created by Raman.Filimonchyk on 07/11/2016.
 */
public class Ad {

    private int ID;
    private int viewNumber;
    private String FK_Model;
    private String FK_Car_body;
    private String FK_Color;
    private int Price;
    private int FK_Users;

    public Ad() {
    }

    public Ad(int ID, int viewNumber, String FK_Model, String FK_Car_body, String FK_Color, int price, int FK_Users) {
        this.ID = ID;
        this.viewNumber = viewNumber;
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

    public int getViewNumber() {
        return viewNumber;
    }

    public void setViewNumber(int viewNumber) {
        this.viewNumber = viewNumber;
    }

    public String getFK_Model() {
        return FK_Model;
    }

    public void setFK_Model(String FK_Model) {
        this.FK_Model = FK_Model;
    }

    public String getFK_Car_body() {
        return FK_Car_body;
    }

    public void setFK_Car_body(String FK_Car_body) {
        this.FK_Car_body = FK_Car_body;
    }

    public String getFK_Color() {
        return FK_Color;
    }

    public void setFK_Color(String FK_Color) {
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
                ", viewNumber=" + viewNumber +
                ", FK_Model='" + FK_Model + '\'' +
                ", FK_Car_body='" + FK_Car_body + '\'' +
                ", FK_Color='" + FK_Color + '\'' +
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
        if (viewNumber != ad.viewNumber) return false;
        if (Price != ad.Price) return false;
        if (FK_Users != ad.FK_Users) return false;
        if (FK_Model != null ? !FK_Model.equals( ad.FK_Model ) : ad.FK_Model != null) return false;
        if (FK_Car_body != null ? !FK_Car_body.equals( ad.FK_Car_body ) : ad.FK_Car_body != null) return false;
        return FK_Color != null ? FK_Color.equals( ad.FK_Color ) : ad.FK_Color == null;

    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + viewNumber;
        result = 31 * result + (FK_Model != null ? FK_Model.hashCode() : 0);
        result = 31 * result + (FK_Car_body != null ? FK_Car_body.hashCode() : 0);
        result = 31 * result + (FK_Color != null ? FK_Color.hashCode() : 0);
        result = 31 * result + Price;
        result = 31 * result + FK_Users;
        return result;
    }
}




