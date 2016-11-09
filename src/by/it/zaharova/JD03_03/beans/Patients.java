package by.it.zaharova.JD03_03.beans;

public class Patients {
    private int ID;
    private String First_name;
    private String Second_name;
    private String Address;
    private String Phone_number;
    private int FK_doctors;

    public Patients() {
    }

    public Patients(int ID, String first_name, String second_name, String address, String phone_number, int FK_doctors) {
        this.ID = ID;
        First_name = first_name;
        Second_name = second_name;
        Address = address;
        Phone_number = phone_number;
        this.FK_doctors = FK_doctors;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirst_name() {
        return First_name;
    }

    public void setFirst_name(String first_name) {
        First_name = first_name;
    }

    public String getSecond_name() {
        return Second_name;
    }

    public void setSecond_name(String second_name) {
        Second_name = second_name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone_number() {
        return Phone_number;
    }

    public void setPhone_number(String phone_number) {
        Phone_number = phone_number;
    }

    public int getFK_doctors() {
        return FK_doctors;
    }

    public void setFK_doctors(int FK_doctors) {
        this.FK_doctors = FK_doctors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patients patients = (Patients) o;

        if (ID != patients.ID) return false;
        if (FK_doctors != patients.FK_doctors) return false;
        if (First_name != null ? !First_name.equals(patients.First_name) : patients.First_name != null) return false;
        if (Second_name != null ? !Second_name.equals(patients.Second_name) : patients.Second_name != null)
            return false;
        if (Address != null ? !Address.equals(patients.Address) : patients.Address != null) return false;
        return Phone_number != null ? Phone_number.equals(patients.Phone_number) : patients.Phone_number == null;

    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + (First_name != null ? First_name.hashCode() : 0);
        result = 31 * result + (Second_name != null ? Second_name.hashCode() : 0);
        result = 31 * result + (Address != null ? Address.hashCode() : 0);
        result = 31 * result + (Phone_number != null ? Phone_number.hashCode() : 0);
        result = 31 * result + FK_doctors;
        return result;
    }

    @Override
    public String toString() {
        return "Patients{" +
                "ID=" + ID +
                ", First_name='" + First_name + '\'' +
                ", Second_name='" + Second_name + '\'' +
                ", Address='" + Address + '\'' +
                ", Phone_number='" + Phone_number + '\'' +
                ", FK_doctors=" + FK_doctors +
                '}';
    }
}
