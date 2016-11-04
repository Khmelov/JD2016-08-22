package by.it.shkantau.jd03.jd03_03.beans;

public class Plane {

    private int id = 0;
    private String planeName;

    public Plane() {
    }

    public Plane(int id, String planeName) {
        this.id = id;
        this.planeName = planeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaneName() {
        return planeName;
    }

    public void setPlaneName(String planeName) {
        this.planeName = planeName;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "id=" + id +
                ", planeName='" + planeName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plane)) return false;

        Plane plane = (Plane) o;

        return id == plane.id && planeName.equals(plane.planeName);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + planeName.hashCode();
        return result;
    }
}
