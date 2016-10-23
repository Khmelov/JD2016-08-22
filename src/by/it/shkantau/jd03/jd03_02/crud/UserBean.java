package by.it.shkantau.jd03.jd03_02.crud;

public class UserBean {
    private int id;
    private String login;
    private String email;
    private String pass;
    private int role;

    public UserBean() {
    }

    public UserBean(int id, String login, String email, String pass, int role) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.pass = pass;
        this.role = role;
    }

    public UserBean(String login, String email, String pass, int role) {
        this.login = login;
        this.email = email;
        this.pass = pass;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserBean userBean = (UserBean) o;

        if (id != userBean.id) return false;
        if (role != userBean.role) return false;
        if (login != null ? !login.equals(userBean.login) : userBean.login != null) return false;
        return email != null ? email.equals(userBean.email) : userBean.email == null && (pass != null ? pass.equals(userBean.pass) : userBean.pass == null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (pass != null ? pass.hashCode() : 0);
        result = 31 * result + role;
        return result;
    }
}
