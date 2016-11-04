package by.it.aborisenok.project.java.beans;

/**
 * Created by Лёша on 21.10.2016.
 */
public class Policlinic {
    private int ID;
    private String Name;
    private String City;
    private String Street;
    private int House;

    public Policlinic (){}

    public Policlinic(int ID, String Name, String City, String Street, int House) {
        this.ID = ID;
        this.Name = Name;
        this.City = City;
        this.Street = Street;
        this.House = House;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String Street) {
        this.Street = Street;
    }

    public int getHouse() {
        return House;
    }

    public void setHouse(int House) {
        this.House = House;
    }

    @Override
    public String toString() {
        return "Policlinic{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", City='" + City + '\'' +
                ", Street='" + Street + '\'' +
                ", House=" + House +
                '}';
    }
}
