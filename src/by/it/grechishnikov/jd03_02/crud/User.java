package by.it.grechishnikov.jd03_02.crud;

public class User implements Entity {
    private int id;
    private String login;
    private String password;
    private String email;
    private int role;

    public User() {
    }

    public User(String login, String password, String email, int role) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public User(int id, String login, String password, String email, int role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", id=" + id +
                '}';
    }
}
