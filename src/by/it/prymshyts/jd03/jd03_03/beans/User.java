package by.it.prymshyts.jd03.jd03_03.beans;

public class User {

    private int ID;
    private String Mail;
    private String Login;
    private String Password;
    private int FK_Role;


    public User() {}

    public User(int ID, String mail, String login, String password, int FK_Role) {
        this.ID = ID;
        Mail = mail;
        Login = login;
        Password = password;
        this.FK_Role = FK_Role;
    }


    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", Mail='" + Mail + '\'' +
                ", Login='" + Login + '\'' +
                ", Password='" + Password + '\'' +
                ", FK_Role=" + FK_Role +
                '}';
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
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
}
