package by.it.aborisenok.JD03_02.crud;

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

    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String specialization) {
        Specialization = specialization;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public int getCabinet() {
        return Cabinet;
    }

    public void setCabinet(int cabinet) {
        Cabinet = cabinet;
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
