package by.it.dubatovka.jd03_02.crud;

public class User {
    private int idUser;
    private String login;
    private String password;
    private String email;
    private int fk_role;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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

    public int getFk_role() {
        return fk_role;
    }

    public void setFk_role(int fk_role) {
        this.fk_role = fk_role;
    }

    public User() {
    }

    public User(int ID, String login, String password, String email, int fk_role) {
        this.idUser = ID;
        this.login = login;
        this.password = password;
        this.email = email;
        this.fk_role = fk_role;
    }

    public User(String login, String password, String email, int fk_role) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.fk_role = fk_role;
    }

    @Override
    public int hashCode() {
        int result = idUser;
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + fk_role;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof User)) return false;

        User user = (User) obj;
        if (fk_role != user.fk_role) return false;
        if (idUser != user.idUser) return false;
        if (!email.equals(user.email)) return false;
        if (!login.equals(user.login)) return false;
        if (!password.equals(user.password)) return false;

        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", fk_role=" + fk_role + "}\n";
    }
}
