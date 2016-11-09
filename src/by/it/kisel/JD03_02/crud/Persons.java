package by.it.kisel.JD03_02.crud;

public class Persons {
    private int ID;
    private String FirstName;
    private String SecondName;
    private String PhoneNumber;
    private String Email;
    private int FK_Role;

    public Persons() {
    }

    public Persons(int ID, String firstName, String secondName, String phoneNumber, String email, int FK_Role) {
        this.ID = ID;
        FirstName = firstName;
        SecondName = secondName;
        PhoneNumber = phoneNumber;
        Email = email;
        this.FK_Role = FK_Role;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getSecondName() {
        return SecondName;
    }

    public void setSecondName(String secondName) {
        SecondName = secondName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getFK_Role() {
        return FK_Role;
    }

    public void setFK_Role(int FK_Role) {
        this.FK_Role = FK_Role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Persons persons = (Persons) o;

        if (ID != persons.ID) return false;
        if (FK_Role != persons.FK_Role) return false;
        if (FirstName != null ? !FirstName.equals(persons.FirstName) : persons.FirstName != null) return false;
        if (SecondName != null ? !SecondName.equals(persons.SecondName) : persons.SecondName != null) return false;
        if (PhoneNumber != null ? !PhoneNumber.equals(persons.PhoneNumber) : persons.PhoneNumber != null) return false;
        return Email != null ? Email.equals(persons.Email) : persons.Email == null;

    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + (FirstName != null ? FirstName.hashCode() : 0);
        result = 31 * result + (SecondName != null ? SecondName.hashCode() : 0);
        result = 31 * result + (PhoneNumber != null ? PhoneNumber.hashCode() : 0);
        result = 31 * result + (Email != null ? Email.hashCode() : 0);
        result = 31 * result + FK_Role;
        return result;
    }

    @Override
    public String toString() {
        return "Persons{" +
                "ID=" + ID +
                ", FirstName='" + FirstName + '\'' +
                ", SecondName='" + SecondName + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", Email='" + Email + '\'' +
                ", FK_Role=" + FK_Role +
                '}';
    }
}
