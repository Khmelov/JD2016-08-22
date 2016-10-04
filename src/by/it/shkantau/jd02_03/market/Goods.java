package by.it.shkantau.jd02_03.market;


 class Goods {
    private String name;
    private double cost;

     Goods(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

     double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
