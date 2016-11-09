package by.it.opiga.JD03_04.Project.java.beans.mybeans;

/**
 * Created by Asus on 19.10.2016.
 */
public class User {
    private int ID;
    private String login;
    private String pass;
    private String email;
    private int FK_role;

    public User() {
    }

    public User(String login, String pass, String email, int FK_role) {
        this.login = login;
        this.pass = pass;
        this.email = email;
        this.FK_role = FK_role;
    }

    public User(int ID, String login, String pass, String email, int FK_role) {
        this.ID = ID;
        this.login = login;
        this.pass = pass;
        this.email = email;
        this.FK_role = FK_role;
    }

    public int getID() {
        return ID;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

    public String getEmail() {
        return email;
    }

    public int getFK_role() {
        return FK_role;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFK_role(int FK_role) {
        this.FK_role = FK_role;

    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", email='" + email + '\'' +
                ", FK_role=" + FK_role +
                '}';
    }

}
