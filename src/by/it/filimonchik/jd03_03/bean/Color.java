package by.it.filimonchik.jd03_03.bean;

/**
 * Created by Raman.Filimonchyk on 07/11/2016.
 */
public class Color {
    private int ID;
    private String Color;

    public Color() {}

    public Color(int ID, String Color) {
        this.ID = ID;
        this.Color = Color;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    @Override
    public String toString() {
        return "Color{" +
                "ID=" + ID +
                ", Color='" + Color + '\'' +
                '}';
    }


}
