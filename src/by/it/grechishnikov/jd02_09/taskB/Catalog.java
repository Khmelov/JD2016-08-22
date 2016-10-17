package by.it.grechishnikov.jd02_09.taskB;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlType(name = "Catalog")
public class Catalog {
    private List<Goods> goods = new ArrayList<>();

    public Catalog() {
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "catalog : " + goods;
    }
}
