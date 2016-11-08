package by.it.filimonchik.jd03_03.bean;

/**
 * Created by Raman.Filimonchyk on 07/11/2016.
 */
public class Model {
    private int ID;
    private String Model;

    public Model() {}

    public Model(int ID, String Model) {
        this.ID = ID;
        this.Model = Model;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    @Override
    public String toString() {
        return "Model{" +
                "ID=" + ID +
                ", Model='" + Model + '\'' +
                '}';
    }


}
