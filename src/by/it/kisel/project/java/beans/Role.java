package by.it.kisel.project.java.beans;

public class Role {
    private int Id;
    private String Role;

    public Role() {
    }

    public Role(int Id, String role) {
        this.Id = Id;
        Role = role;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
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
                "Id=" + Id +
                ", Role='" + Role + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        by.it.kisel.project.java.beans.Role role = (by.it.kisel.project.java.beans.Role) o;

        if (Id != role.Id) return false;
        return Role != null ? Role.equals(role.Role) : role.Role == null;

    }

    @Override
    public int hashCode() {
        int result = Id;
        result = 31 * result + (Role != null ? Role.hashCode() : 0);
        return result;
    }
}
