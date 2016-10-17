package by.it.prymshyts.jd02.jd02_10.Task3;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "book")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "title",
        "authors",
        "year",
        "count"
})
class Book {

    @XmlElement(required = true)
    private String title;
    @XmlElement(required = true)
    private Authors authors;
    @XmlElement(required = true)
    private Integer year;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    private Integer count;

    public Book() {}

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authors=" + authors +
                ", year=" + year +
                ", count=" + count +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Authors getAuthors() {
        return authors;
    }

    public void setAuthors(Authors authors) {
        this.authors = authors;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
