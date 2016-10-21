package by.it.aborisenok.JD03_02.crud;

import by.it.akhmelev.jd01_06.Level_A.Data;

/**
 * Created by Лёша on 21.10.2016.
 */
public class Date {
    private int ID;
    private Data data;
    private int FK_Doctor;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public int getFK_Doctor() {
        return FK_Doctor;
    }

    public void setFK_Doctor(int FK_Doctor) {
        this.FK_Doctor = FK_Doctor;
    }

    @Override
    public String toString() {
        return "Date{" +
                "ID=" + ID +
                ", data=" + data +
                ", FK_Doctor=" + FK_Doctor +
                '}';
    }
}
