package by.it.shkantau.jd01_08;

/**
 * Created by Aliaksei on 13.09.2016.
 */
public  abstract class Player implements ElectronicDevice {
    protected String name;
    private double weight;
    private String type;

    public Player(String name, double weight, String type) {
        this.name = name;
        this.weight = weight;
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    abstract void  play();
    abstract  void stop();
    abstract  void pause();

    public String toString(){
        return this.getClass().getName() + "name-"+name+", weigth-"+weight+", type-"+type;
    }

}
