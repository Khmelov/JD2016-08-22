package by.it.aborisenok.JD03_02.crud;

import java.sql.Timestamp;

/**
 * Created by Лёша on 21.10.2016.
 */
public class User {
    private int ID;
    private String login;
    private String password;
    private String name;
    private String surname;
    private Timestamp birthDay;
    private String city;
    private String street;
    private int house;
    private int flat;
    private int FK_Role;

    public User(){}

    public User(int ID, String login, String password, String name, String surname, Timestamp birthDay, String city, String street, int house, int flat, int FK_Role) {
        this.ID = ID;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.birthDay = birthDay;
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = flat;
        this.FK_Role = FK_Role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Timestamp getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Timestamp birthDay) {
        this.birthDay = birthDay;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public int getFlat() {
        return flat;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }

    public int getFK_Role() {
        return FK_Role;
    }

    public void setFK_Role(int FK_Role) {
        this.FK_Role = FK_Role;
    }

    @Override
    public String toString() {
        return "User{ID=" + ID + ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDay=" + birthDay +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house=" + house +
                ", flat=" + flat +
                ", FK_Role=" + FK_Role +
                '}';
    }
}
