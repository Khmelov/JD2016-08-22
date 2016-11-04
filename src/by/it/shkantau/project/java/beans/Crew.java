package by.it.shkantau.project.java.beans;

public class Crew {
    private int id=0;
    private int pilot1;
    private int pilot2;
    private int airhostess1;
    private int airhostess2;

    public Crew() {
    }

    public Crew(int id, int pilot1, int pilot2, int airhostess1, int airhostess2) {
        this.id = id;
        this.pilot1 = pilot1;
        this.pilot2 = pilot2;
        this.airhostess1 = airhostess1;
        this.airhostess2 = airhostess2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPilot1() {
        return pilot1;
    }

    public void setPilot1(int pilot1) {
        this.pilot1 = pilot1;
    }

    public int getPilot2() {
        return pilot2;
    }

    public void setPilot2(int pilot2) {
        this.pilot2 = pilot2;
    }

    public int getAirhostess1() {
        return airhostess1;
    }

    public void setAirhostess1(int airhostess1) {
        this.airhostess1 = airhostess1;
    }

    public int getAirhostess2() {
        return airhostess2;
    }

    public void setAirhostess2(int airhostess2) {
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
}
