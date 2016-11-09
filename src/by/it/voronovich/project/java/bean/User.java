package by.it.voronovich.project.java.bean;

import java.io.Serializable;

public class User implements Serializable{

    private int idUsers;
    private String Name;
    private String Surname;
    private String Login;
    private String Password;
    private String Email;
    private int FK_Role;

    public User() {
    }

    public User(int idUsers, String Name, String Surname, String Login, String Password, String Email, int FK_Role) {
        this.idUsers = idUsers;
        this.Name = Name;
        this.Surname = Surname;
        this.Login = Login;
        this.Password = Password;
        this.Email = Email;
        this.FK_Role = FK_Role;
    }

    @Override
    public int hashCode() {
        int result = idUsers;
        result = 31 * result + Name.hashCode();
        result = 31 * result + Surname.hashCode();
        result = 31 * result + Login.hashCode();
        result = 31 * result + Password.hashCode();
        result = 31 * result + Email.hashCode();
        result = 31 * result + FK_Role;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (FK_Role != user.FK_Role) return false;
        if (idUsers != user.idUsers) return false;
        if (!Name.equals(user.Name)) return false;
        if (!Surname.equals(user.Surname)) return false;
        if (!Login.equals(user.Login)) return false;
        if (!Password.equals(user.Password)) return false;
        if (!Email.equals(user.Email)) return false;

        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUsers=" + idUsers +
                ", Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", Login='" + Login + '\'' +
                ", Password='" + Password + '\'' +
                ", Email='" + Email + '\'' +
                ", FK_Role=" + FK_Role +
                "}\n";
    }

    public int getIdUsers() {
        return idUsers;
    }

    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }

    public String getLogin() {
        return Login;
    }

    public String getPassword() {
        return Password;
    }

    public String getEmail() {
        return Email;
    }

    public int getFK_Role() {
        return FK_Role;
    }

    public void setIdUsers(int idUsers) {
        this.idUsers = idUsers;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setFK_Role(int FK_Role) {
        this.FK_Role = FK_Role;
    }
}
