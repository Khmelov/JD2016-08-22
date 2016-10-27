package by.it.dubatovka.jd03_02.crud;


public class Objects {
    private int idObject;
    private String zia;

    public Objects() {
    }

    public Objects(int idObject, String zia) {
        this.idObject = idObject;
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

    public int getIdObject() {
        return idObject;
    }

    public void setIdObject(int idObject) {
        this.idObject = idObject;
    }

    @Override
    public String toString() {
        return "Objects{" +
                "idObject=" + idObject +
                ", zia='" + zia + '\'' +
                '}';
    }

}
