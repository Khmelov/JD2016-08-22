package by.it.filimonchik.jd02_09.Task_B;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Dillers", propOrder = {
        "diller"
})

public class Dillers {

    @XmlElement(required = true)

    private ArrayList<Diller> diller = new ArrayList<Diller>();

    public Dillers() {
    }

    public Dillers(ArrayList<Diller> diller) {
        this.diller = diller;
    }

    public void setList(ArrayList<Diller> diller) {
        this.diller = diller;
    }

    public ArrayList<Diller> getList() {
        return diller;
    }

    public boolean add(Diller value) {
        return diller.add(value);
    }

    @Override
    public String toString() {
        return String.valueOf(diller);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

