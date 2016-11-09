package by.it.opiga.JD03_04.Project.java.beans.mybeans;

/**
 * Created by Asus on 24.10.2016.
 */
public class Role {
    private int ID;
    private String role;

    public Role() {
    }

    public Role(int ID, String role) {
        this.ID = ID;
        this.role = role;
    }

    public int getID() {
        return ID;
    }

    public String getRole() {
        return role;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role1 = (Role) o;

        if (ID != role1.ID) return false;
        return role != null ? role.equals(role1.role) : role1.role == null;

    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
}
