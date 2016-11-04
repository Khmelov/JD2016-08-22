package by.it.aborisenok.JD03_02.crud;

/**
 * Created by aborisenok on 26.10.2016.
 */
public class Role {
    private int ID;
    private String role;

    public Role() {}

    public Role(int ID, String role) {
        this.ID = ID;
        this.role = role;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Role{" +
                "ID=" + ID +
                ", role='" + role + '\'' +
                '}';
    }
}
