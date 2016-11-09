package by.it.shkantau.jd03.jd03_03.beans;

import java.util.Date;

public class Pilot {
    private int id=0;
    private String name;
    private String phoneNumber;
    private Date birthDay;

    public Pilot() {
    }

    public Pilot(int id, String name, String phoneNumber, Date birthDay) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return "Pilot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birthDay=" + birthDay +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pilot)) return false;

        Pilot pilot = (Pilot) o;

        if (id != pilot.id) return false;
        if (!name.equals(pilot.name)) return false;
        if (phoneNumber != null ? !phoneNumber.equals(pilot.phoneNumber) : pilot.phoneNumber != null) return false;
        return birthDay != null ? birthDay.equals(pilot.birthDay) : pilot.birthDay == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (birthDay != null ? birthDay.hashCode() : 0);
        return result;
    }
}
