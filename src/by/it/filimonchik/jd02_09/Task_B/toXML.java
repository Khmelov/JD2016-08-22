package by.it.filimonchik.jd02_09.Task_B;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class toXML{
    public static void Task_B() throws JAXBException, FileNotFoundException {

        ArrayList<Diller> list = new ArrayList<>();
        Diller diller = new Diller("Ivan", "Audi");
        list.add(diller);
        diller = new Diller("Vasia", "Ferrari");
        list.add(diller);

        Dillers dillers = new Dillers();
        dillers.setList(list);

        ArendaAuto arendaauto = new ArendaAuto();
        arendaauto.setDillers(dillers);

        try {
            JAXBContext context = JAXBContext.newInstance(ArendaAuto.class);
            Marshaller marshaller = context.createMarshaller();
            File file = new File("src/by/it/filimonchik/JD02_09/Task_B/auto.xml");
            marshaller.marshal(arendaauto, new FileOutputStream(file));
            System.out.println("XML-файл создан");
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(arendaauto, System.out);
        } catch (FileNotFoundException e) {
            System.out.println("XML-файл не может быть создан: " + e);
        } catch (JAXBException e) {
            System.out.println("JAXB-контекст ошибочен " + e);
        }
    }
}
