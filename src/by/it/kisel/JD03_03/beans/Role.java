package by.it.kisel.JD03_03.beans;

public class Role {
    private int ID;
    private String Role;

    public Role() {
    }

    public Role(int ID, String role) {
        this.ID = ID;
        Role = role;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    @Override
    public String toString() {
        return "Role{" +
                "ID=" + ID +
                ", Role='" + Role + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (ID != role.ID) return false;
        return Role != null ? Role.equals(role.Role) : role.Role == null;

    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + (Role != null ? Role.hashCode() : 0);
        return result;
    }
}
