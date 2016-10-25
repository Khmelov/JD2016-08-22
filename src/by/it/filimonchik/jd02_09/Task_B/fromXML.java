package by.it.filimonchik.jd02_09.Task_B;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Raman.Filimonchyk on 23/10/2016.
 */
public class fromXML {
    public static void Task_B() throws JAXBException, FileNotFoundException {
        try{
            JAXBContext jaxbContext=JAXBContext.newInstance(ArendaAuto.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            FileReader reader = new FileReader("src/by/it/filimonchik/JD02_09/Task_B/auto.xml");
            System.out.println("XML-файл прочитан");
            ArendaAuto arendaAuto = (ArendaAuto) unmarshaller.unmarshal( reader );
            System.out.println(arendaAuto);

        }catch (Exception e){
            System.out.println("Ошибка");
        }
    }
}
