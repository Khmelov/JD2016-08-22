package by.it.shkantau.jd03.jd03_03.beans;

public class Crew {
    private int id=0;
    private Pilot pilot1;
    private Pilot pilot2;
    private Airhostess airhostess1;
    private Airhostess airhostess2;

    public Crew() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pilot getPilot1() {
        return pilot1;
    }

    public void setPilot1(Pilot pilot1) {
        this.pilot1 = pilot1;
    }

    public Pilot getPilot2() {
        return pilot2;
    }

    public void setPilot2(Pilot pilot2) {
        this.pilot2 = pilot2;
    }

    public Airhostess getAirhostess1() {
        return airhostess1;
    }

    public void setAirhostess1(Airhostess airhostess1) {
        this.airhostess1 = airhostess1;
    }

    public Airhostess getAirhostess2() {
        return airhostess2;
    }

    public void setAirhostess2(Airhostess airhostess2) {
        this.airhostess2 = airhostess2;
    }

    @Override
    public String toString() {
        return "Crew{" +
                "id=" + id +
                ", pilot1=" + pilot1 +
                ", pilot2=" + pilot2 +
                ", airhostess1=" + airhostess1 +
                ", airhostess2=" + airhostess2 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Crew)) return false;

        Crew crew = (Crew) o;

        if (id != crew.id) return false;
        if (!pilot1.equals(crew.pilot1)) return false;
        if (pilot2 != null ? !pilot2.equals(crew.pilot2) : crew.pilot2 != null) return false;
        if (!airhostess1.equals(crew.airhostess1)) return false;
        return airhostess2 != null ? airhostess2.equals(crew.airhostess2) : crew.airhostess2 == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + pilot1.hashCode();
        result = 31 * result + (pilot2 != null ? pilot2.hashCode() : 0);
        result = 31 * result + airhostess1.hashCode();
        result = 31 * result + (airhostess2 != null ? airhostess2.hashCode() : 0);
        return result;
    }
}
