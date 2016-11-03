package by.it.aborisenok.JD03_03.beans;

/**
 * Created by Лёша on 21.10.2016.
 */
public class Doctor {
    private int ID;
    private String Name;
    private String Surname;
    private String Specialization;
    private String Category;
    private int Cabinet;
    private int FK_Policlinic;

    public Doctor(){}

    public int getID() {
        return ID;
    }

    public Doctor(int ID, String Name, String Surname, String Specialization, String Category, int Cabinet, int FK_Policlinic) {
        this.ID = ID;
        this.Name = Name;
        this.Surname = Surname;
        this.Specialization = Specialization;
        this.Category = Category;
        this.Cabinet = Cabinet;
        this.FK_Policlinic = FK_Policlinic;
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

    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String Specialization) {
        this.Specialization = Specialization;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public int getCabinet() {
        return Cabinet;
    }

    public void setCabinet(int Cabinet) {
        this.Cabinet = Cabinet;
    }

    public int getFK_Policlinic() {
        return FK_Policlinic;
    }

    public void setFK_Policlinic(int FK_Policlinic) {
        this.FK_Policlinic = FK_Policlinic;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", Specialization='" + Specialization + '\'' +
                ", Category='" + Category + '\'' +
                ", Cabinet=" + Cabinet +
                ", FK_Policlinic=" + FK_Policlinic +
                '}';
    }
}
