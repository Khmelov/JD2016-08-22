package by.it.snegurskiy.Project.java.Bean;

public class Users {

    private int ID;
    private String Surname;
    private String Name;
    private String Login;
    private String Password;
    private int FK_Role;
    private int FK_Status;


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getFK_Role() {
        return FK_Role;
    }

    public void setFK_Role(int FK_Role) {
        this.FK_Role = FK_Role;
    }

    public int getFK_Status() {
        return FK_Status;
    }

    public void setFK_Status(int FK_Status) {
        this.FK_Status = FK_Status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;

        Users user = (Users) o;

        if (FK_Role != user.FK_Role) return false;
        if (FK_Status != user.FK_Status) return false;
        if (ID != user.ID) return false;
        if (!Login.equals(user.Login)) return false;
        if (!Password.equals(user.Password)) return false;
        if (!Surname.equals(user.Surname)) return false;
        if (!Name.equals(user.Name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + Surname.hashCode();
        result = 31 * result + Name.hashCode();
        result = 31 * result + Login.hashCode();
        result = 31 * result + Password.hashCode();
        result = 31 * result + FK_Role;
        return result;
    }

    public Users() {
    }

    public Users(int ID, String surname, String name, String login, String password, int FK_Role, int FK_Status) {
        this.ID = ID;
        Surname = surname;
        Name = name;
        Login = login;
        Password = password;
        this.FK_Role = FK_Role;
        this.FK_Status = FK_Status;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", Surname='" + Surname + '\'' +
                ", Name='" + Name + '\'' +
                ", Login='" + Login + '\'' +
                ", Password='" + Password + '\'' +
                ", FK_Role=" + FK_Role +
                ", FK_Status=" + FK_Status +
                "}\n";
    }
}
