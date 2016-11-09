package by.it.shkantau.jd03.jd03_03.beans;

public class Airport {
    private int id=0;
    private String acronim;
    private String name;

    public Airport() {
    }

    public Airport(int id, String acronim, String name) {
        this.id = id;
        this.acronim = acronim;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAcronim() {
        return acronim;
    }

    public void setAcronim(String acronim) {
        this.acronim = acronim;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", acronim='" + acronim + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airport)) return false;

        Airport airport = (Airport) o;

        if (id != airport.id) return false;
        if (!acronim.equals(airport.acronim)) return false;
        return name.equals(airport.name);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + acronim.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
