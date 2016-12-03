package by.it.zaharova.JD02_10.Task1;

import java.util.Arrays;

@SuppressWarnings("ALL")
public class Test {

    private int ID         = 0;
    private String name    = null;
    private Double[] marks = new Double[5];

    public Test() {}

    public Test(String name, Double[] marks) {
        this.ID++;
        this.name = name;
        this.marks = marks;
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

    public Double[] getMarks() {
        return marks;
    }

    public void setMarks(Double[] marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Test{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", marks=" + Arrays.toString(marks) +
                '}';
    }
}
