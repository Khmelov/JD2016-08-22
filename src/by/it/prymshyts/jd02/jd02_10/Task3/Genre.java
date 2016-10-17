package by.it.prymshyts.jd02.jd02_10.Task3;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "genre")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "book"
})
class Genre {

    @XmlElement(required = true)
    private List<Book> book;
    @XmlAttribute(name = "name", required = true)
    private String name;

    public Genre() {}

    @Override
    public String toString() {
        return "Genre{" +
                "book=" + book +
                ", name='" + name + '\'' +
                '}';
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        if (book == null) {
            book = new ArrayList<>();
        }
        this.book = book;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
