package by.it.voronovich.JD03_03.bean;

import java.io.Serializable;

public class Role implements Serializable{

    private int idRole;
    private String Name;

    public Role() {

    }

    public Role(int idRole, String Name) {
        this.idRole = idRole;
        this.Name = Name;
    }

    @Override
    public int hashCode() {
    int result = idRole;
    result = 31 * result + Name.hashCode();
    return result;
}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (idRole != role.idRole) return false;
        if (!Name.equals(role.Name)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Role{" +
                "idRole=" + idRole +
                ", Name='" + Name + '\'' +
                "}\n";
    }

    public int getIdRole() {
        return idRole;
    }

    public String getName() {
        return Name;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public void setName(String name) {
        Name = name;
    }
}
