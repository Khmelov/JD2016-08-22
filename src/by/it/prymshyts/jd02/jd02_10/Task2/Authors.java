package by.it.prymshyts.jd02.jd02_10.Task2;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "authors")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "author"
})
class Authors {

    @XmlElement(required = true)
    private List<String> author;

    public Authors() {}

    @Override
    public String toString() {
        return "Authors{" +
                "author=" + author +
                '}';
    }

    public List<String> getAuthor() {
        if (author == null) {
            author = new ArrayList<>();
        }
        return author;
    }

    public void setAuthor(List<String> author) {
        this.author = author;
    }
}
