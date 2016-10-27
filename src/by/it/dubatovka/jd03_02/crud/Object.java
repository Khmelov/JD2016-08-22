package by.it.dubatovka.jd03_02.crud;


public class Object {
    private int idObject;
    private String zia;

    public Object() {
    }

    public Object(int idObject, String zia) {
        this.idObject = idObject;
        this.zia = zia;
    }

    public Object(String zia) {
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

    @Override
    public String toString() {
        return "Object{" +
                "idObject=" + idObject +
                ", zia='" + zia + '\'' +
                '}';
    }

}
