package by.it.aborisenok.JD03_02.crud;

/**
 * Created by Лёша on 21.10.2016.
 */
public class Policlinic {
    private int ID;
    private String Name;
    private String City;
    private String Street;
    private int House;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public int getHouse() {
        return House;
    }

    public void setHouse(int house) {
        House = house;
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
