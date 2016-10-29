package by.it.filimonchik.jd02_10.Task_B;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "arendaAuto", propOrder = {
        "dillers"
})

public class ArendaAuto {

    @XmlElement(required = true)
    private Dillers dillers = new Dillers();

    public ArendaAuto() {
    }

    public ArendaAuto(Dillers dillers) {
        this.dillers = dillers;
    }

    public Dillers getDillers() {
        return dillers;
    }

    public void setDillers(Dillers dillers) {
        this.dillers = dillers;
    }
    @Override
    public String toString() {
        return "List of dillers: " + "\n" + dillers;
    }
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}