package by.it.filimonchik.jd03_03.bean;

/**
 * Created by Raman.Filimonchyk on 07/11/2016.
 */
public class Role {
    private int ID;
    private String Role;

    public Role() {}

    public Role(int ID, String Role) {
        this.ID = ID;
        this.Role = Role;
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

    public void setRole(String Role) {
        this.Role = Role;
    }

    @Override
    public String toString() {
        return "Role{" +
                "ID=" + ID +
                ", Role='" + Role + '\'' +
                '}';
    }


}
