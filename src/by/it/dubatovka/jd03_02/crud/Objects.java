package by.it.dubatovka.jd03_02.crud;


public class Objects {
    private int ID;
    private String zia;

    public Objects() {
    }

    public Objects(int ID, String zia) {
        this.ID = ID;
        this.zia = zia;
    }

    public Objects(String zia) {
        this.zia = zia;
    }

    public String getZia() {
        return zia;
    }

    public void setZia(String zia) {
        this.zia = zia;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Objects{" +
                "ID=" + ID +
                ", zia='" + zia + '\'' +
                '}';
    }

}
