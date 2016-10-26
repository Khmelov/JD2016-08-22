package by.it.aborisenok.JD03_02.crud;

/**
 * Created by Лёша on 21.10.2016.
 */
public class Talon {
    private int ID;
    private int FK_Policlinic;
    private int FK_Pacient;
    private int FK_Doctor;
    private int FK_VisitDate;

    public Talon(){}

    public Talon(int ID, int FK_Policlinic, int FK_Pacient, int FK_Doctor, int FK_VisitDate) {
        this.ID = ID;
        this.FK_Policlinic = FK_Policlinic;
        this.FK_Pacient = FK_Pacient;
        this.FK_Doctor = FK_Doctor;
        this.FK_VisitDate = FK_VisitDate;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getFK_Policlinic() {
        return FK_Policlinic;
    }

    public void setFK_Policlinic(int FK_Policlinic) {
        this.FK_Policlinic = FK_Policlinic;
    }

    public int getFK_Pacient() {
        return FK_Pacient;
    }

    public void setFK_Pacient(int FK_Pacient) {
        this.FK_Pacient = FK_Pacient;
    }

    public int getFK_Doctor() {
        return FK_Doctor;
    }

    public void setFK_Doctor(int FK_Doctor) {
        this.FK_Doctor = FK_Doctor;
    }

    public int getFK_VisitDate() {
        return FK_VisitDate;
    }

    public void setFK_VisitDate(int FK_VisitDate) {
        this.FK_VisitDate = FK_VisitDate;
    }

    @Override
    public String toString() {
        return "Talon{" +
                "ID=" + ID +
                ", FK_Policlinic=" + FK_Policlinic +
                ", FK_Pacient=" + FK_Pacient +
                ", FK_Doctor=" + FK_Doctor +
                ", FK_VisitDate=" + FK_VisitDate +
                '}';
    }
}
