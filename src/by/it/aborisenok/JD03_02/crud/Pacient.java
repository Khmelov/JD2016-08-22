package by.it.aborisenok.JD03_02.crud;

import by.it.akhmelev.jd01_06.Level_A.Data;

import java.sql.Timestamp;

/**
 * Created by Лёша on 21.10.2016.
 */
public class Pacient {
    private int ID;
    private String Name;
    private String Surname;
    private Timestamp BirthDay;
    private String City;
    private String Street;
    private int House;
    private int Flat;
    private int FK_Role;

    public Pacient(){}

    public Pacient(int ID, String Name, String Surname, Timestamp BirthDay, String City, String Street, int House, int Flat,int FK_Role) {
        this.ID = ID;
        this.Name = Name;
        this.Surname = Surname;
        this.BirthDay = BirthDay;
        this.City = City;
        this.Street = Street;
        this.House = House;
        this.Flat = Flat;
        this.FK_Role = FK_Role;
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

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    public Timestamp getBirthDay() {
        return BirthDay;
    }

    public void setBirthDay(Timestamp BirthDay) {
        this.BirthDay = BirthDay;
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

    public int getFlat() {
        return Flat;
    }

    public void setFlat(int Flat) {
        this.Flat = Flat;
    }

    public int getFK_Role() {
        return FK_Role;
    }

    public void setFK_Role(int FK_Role) {
        this.FK_Role = FK_Role;
    }

    @Override
    public String toString() {
        return "Pacient{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", BirthDay=" + BirthDay +
                ", City='" + City + '\'' +
                ", Street='" + Street + '\'' +
                ", House=" + House +
                ", Flat=" + Flat +
                ", FK_Role=" + FK_Role +
                '}';
    }
}
