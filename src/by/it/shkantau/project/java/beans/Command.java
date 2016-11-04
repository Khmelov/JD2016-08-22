package by.it.shkantau.project.java.beans;

public class Command {
    private int id =0;
    private String action;
    private boolean permission;
    private int role;

    public Command() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public boolean isPermission() {
        return permission;
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Command{" +
                "id=" + id +
                ", action='" + action + '\'' +
                ", permission=" + permission +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Command)) return false;

        Command command = (Command) o;

        if (id != command.id) return false;
        if (permission != command.permission) return false;
        if (role != command.role) return false;
        return action.equals(command.action);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + action.hashCode();
        result = 31 * result + (permission ? 1 : 0);
        result = 31 * result + role;
        return result;
    }
}
