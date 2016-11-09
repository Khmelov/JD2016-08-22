package by.it.zaharova.JD03_03.beans;

public class Doctors {
    private int ID;
    private String Name_surname;
    private String Speciality;
    private String Phone_number;
    private String Cabinet;

    public Doctors() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName_surname() {
        return Name_surname;
    }

    public void setName_surname(String name_surname) {
        Name_surname = name_surname;
    }

    public String getSpeciality() {
        return Speciality;
    }

    public void setSpeciality(String speciality) {
        Speciality = speciality;
    }

    public String getPhone_number() {
        return Phone_number;
    }

    public void setPhone_number(String phone_number) {
        Phone_number = phone_number;
    }

    public String getCabinet() {
        return Cabinet;
    }

    public void setCabinet(String cabinet) {
        Cabinet = cabinet;
    }

    public Doctors(int ID, String name_surname, String speciality, String phone_number, String cabinet) {
        this.ID = ID;
        Name_surname = name_surname;
        Speciality = speciality;
        Phone_number = phone_number;
        Cabinet = cabinet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Doctors doctors = (Doctors) o;

        if (ID != doctors.ID) return false;
        if (Name_surname != null ? !Name_surname.equals(doctors.Name_surname) : doctors.Name_surname != null)
            return false;
        if (Speciality != null ? !Speciality.equals(doctors.Speciality) : doctors.Speciality != null) return false;
        if (Phone_number != null ? !Phone_number.equals(doctors.Phone_number) : doctors.Phone_number != null)
            return false;
        return Cabinet != null ? Cabinet.equals(doctors.Cabinet) : doctors.Cabinet == null;

    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + (Name_surname != null ? Name_surname.hashCode() : 0);
        result = 31 * result + (Speciality != null ? Speciality.hashCode() : 0);
        result = 31 * result + (Phone_number != null ? Phone_number.hashCode() : 0);
        result = 31 * result + (Cabinet != null ? Cabinet.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Doctors{" +
                "ID=" + ID +
                ", Name_surname='" + Name_surname + '\'' +
                ", Speciality='" + Speciality + '\'' +
                ", Phone_number='" + Phone_number + '\'' +
                ", Cabinet='" + Cabinet + '\'' +
                '}';
    }
}
