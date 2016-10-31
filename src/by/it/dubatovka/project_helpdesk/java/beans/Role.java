package by.it.dubatovka.project_helpdesk.java.beans;


public class Role {
    private int ID;
    private String roleName;

    public Role() {
    }

    public Role(int ID, String roleName) {
        this.ID = ID;
        this.roleName = roleName;
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Role{" +
                "ID=" + ID +
                ", roleName='" + roleName + '\'' +
                '}';
    }

  }
