package by.it.shkantau.project.java.beans;

public class Role {
    public static final int ADMINISTRATOR_ROLE=1;
    public static final int DISPATCHER_ROLE=2;
    public static final int USER_ROLE =3;
    private int id = 0;
    private String role;

    public Role() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;

        Role role1 = (Role) o;

        if (id != role1.id) return false;
        return role.equals(role1.role);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + role.hashCode();
        return result;
    }
}
