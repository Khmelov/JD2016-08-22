package by.it.dubatovka.jd03_02.crud;


public class Role {
    private int idRole;
    private String roleName;

    public Role() {
    }

    public Role(int idRole, String roleName) {
        this.idRole = idRole;
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

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    @Override
    public String toString() {
        return "Role{" +
                "idRole=" + idRole +
                ", roleName='" + roleName + '\'' +
                '}';
    }

  }
