package by.it.prymshyts.jd03.project.java.beans;

public class Role {

    private int ID;
    private String Role;


    public Role() {}

    public Role(int ID, String role) {
        this.ID = ID;
        Role = role;
    }


    @Override
    public String toString() {
        return "Role{" +
                "ID=" + ID +
                ", Role='" + Role + '\'' +
                '}';
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
}
