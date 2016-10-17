package by.it.prymshyts.jd02.jd02_10.Task2;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "catalog")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "genre"
})
class Catalog {

    @XmlElement(required = true)
    private List<Genre> genre;

    public Catalog() {}

    @Override
    public String toString() {
        return "Catalog{" +
                "genre=" + genre +
                '}';
    }

    public List<Genre> getGenre() {
        if (genre == null) {
            genre = new ArrayList<>();
        }
        return genre;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }
}
