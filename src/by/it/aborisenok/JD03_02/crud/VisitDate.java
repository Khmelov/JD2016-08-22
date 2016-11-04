package by.it.aborisenok.JD03_02.crud;


import java.sql.Timestamp;

/**
 * Created by Лёша on 21.10.2016.
 */
public class VisitDate {
    private int ID;
    private Timestamp visitTime;
    private int FK_Doctor;

    public VisitDate(){

    }

    public VisitDate(int ID, Timestamp visitTime, int FK_Doctor){
        this.ID = ID;
        this.visitTime = visitTime;
        this.FK_Doctor = FK_Doctor;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Timestamp getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Timestamp visitTime) {
        this.visitTime = visitTime;
    }

    public int getFK_Doctor() {
        return FK_Doctor;
    }

    public void setFK_Doctor(int FK_Doctor) {
        this.FK_Doctor = FK_Doctor;
    }

    @Override
    public String toString() {
        return "VisitDate{" +
                "ID=" + ID +
                ", visitTime=" + visitTime +
                ", FK_Doctor=" + FK_Doctor +
                '}';
    }
}
