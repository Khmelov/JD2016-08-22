package by.it.grechishnikov.jd02_09.taskB;

import javax.xml.bind.annotation.*;

@XmlType(name = "Goods")
public class Goods {
    private String description;
    private int price;

    public Goods() {
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return description + " : " + price;
    }
}
