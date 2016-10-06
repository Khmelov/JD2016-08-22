package by.it.shkantau.jd02.jd02_03.market;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class PriceList {

    private List<Goods> price = Collections.synchronizedList(new ArrayList<Goods>(){{
        add(new Goods("Oil", 73.2));
        add(new Goods("Sausages", 74.2));
        add(new Goods("Bred", 33.0));
        add(new Goods("Milk", 52.1));
        add(new Goods("Apple", 20.8));
        add(new Goods("Cheese", 71.5));
        add(new Goods("Water 1L", 15.0));
        add(new Goods("Tea", 54.3));
        add(new Goods("Roll", 14.3));
    }}
    );

   Goods getRandomGoods(){
       int rand = Helper.random(0, price.size()-1);
       return  price.get(rand);
   }

   public void addGoodsToPriceList(Goods goods){
       this.price.add(goods);
   }

   public void addGoodsToPriceList(String name, double cost){
       this.price.add(new Goods(name, cost));
   }

   public  List<Goods> getPrice() {
       return price;
   }

   public  void setPrice(List<Goods> price) {
       this.price = price;
   }

}
