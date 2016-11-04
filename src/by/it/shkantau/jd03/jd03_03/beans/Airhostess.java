package by.it.shkantau.jd03.jd03_03.beans;

import java.util.Date;

public class Airhostess {
    private int id=0;
    private String name;
    private Date birthDay;

    public Airhostess() {
    }

    public Airhostess(int id, String name, Date birthDay) {
        this.id = id;
        this.name = name;
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

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return "Airhostess{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDay=" + birthDay +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airhostess)) return false;

        Airhostess that = (Airhostess) o;

        if (id != that.id) return false;
        if (!name.equals(that.name)) return false;
        return birthDay.equals(that.birthDay);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + birthDay.hashCode();
        return result;
    }
}
