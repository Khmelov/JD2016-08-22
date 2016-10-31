package by.it.snegurskiy.jd02_09;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
public class JAXB2XML {
    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(Users.class);
            Marshaller m = context.createMarshaller();
            Users user = new Users() { // анонимный класс
                {
                    // добавление первого студента
                    User.Account acc = new User.Account(500);
                    User s = new User("Vasya", "Vasya", "Vasya", "Vasya1", acc);
                    this.add(s);
                    // добавление второго студента
                    acc = new User.Account(5000);
                    s = new User("Petya", "Petya", "Petya", "Petya1", acc);
                    this.add(s);
                }
            };
            m.marshal(user, new FileOutputStream("src/by/it/snegurskiy/jd02_09/user+xsd.xml"));
            System.out.println("XML-файл создан");
            m.marshal(user, System.out); // копия на консоль
        } catch (FileNotFoundException e) {System.out.println("XML-файл не может быть создан: " + e);}
        catch (JAXBException e) {        System.out.println("JAXB-контекст ошибочен " + e);        }
    }
}