package by.it.prymshyts.jd02.jd02_09;

import by.it.prymshyts.jd02.jd02_09.manual_pojo.Authors;
import by.it.prymshyts.jd02.jd02_09.manual_pojo.Book;
import by.it.prymshyts.jd02.jd02_09.manual_pojo.Catalog;
import by.it.prymshyts.jd02.jd02_09.manual_pojo.Genre;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

class JAXB2XML {
    public static void main(String[] args) {
        try {
            JAXBContext context   = JAXBContext.newInstance(Catalog.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            Catalog catalog = new Catalog() {
                {
                    this.setGenre(JAXB2XML.getGenre());
                }
            };

            String fileName = "src/by/it/prymshyts/jd02/jd02_09/manual_pojo/catalog.xml";
            marshaller.marshal(catalog, new FileOutputStream(fileName));
            System.out.println("XML создан.");
            marshaller.marshal(catalog, System.out);
        } catch (FileNotFoundException e) {
            System.err.println("XML не может быть создан.");
        } catch (JAXBException e) {
            System.err.println("JAXB-контекст ошибочен.");
        }
    }

    private static ArrayList<Genre> getGenre() {
        ArrayList<Genre> genres  = new ArrayList<>();

        Genre genre              = new Genre();
        ArrayList<Book> books    = new ArrayList<>();
        Book book                = new Book();
        Authors authors          = new Authors();
        ArrayList<String> author = new ArrayList<>();

        author.add("Howard Phillips Lovecraft");
        authors.setAuthor(author);
        book.setAuthors(authors);
        book.setTitle("The Tomb");
        book.setYear(1917);
        book.setCount(13);
        books.add(book);
        genre.setBook(books);
        genre.setName("Horror");
        genres.add(genre);

        return genres;
    }
}
