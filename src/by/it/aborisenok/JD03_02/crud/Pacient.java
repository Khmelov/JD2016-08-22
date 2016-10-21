package by.it.aborisenok.JD03_02.crud;

import by.it.akhmelev.jd01_06.Level_A.Data;

/**
 * Created by Лёша on 21.10.2016.
 */
public class Pacient {
    private int ID;
    private String Name;
    private String Surname;
    private Data BirthDay;
    private String City;
    private String Street;
    private int House;
    private int Flat;

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

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public Data getBirthDay() {
        return BirthDay;
    }

    public void setBirthDay(Data birthDay) {
        BirthDay = birthDay;
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

    public int getFlat() {
        return Flat;
    }

    public void setFlat(int flat) {
        Flat = flat;
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
                '}';
    }
}
