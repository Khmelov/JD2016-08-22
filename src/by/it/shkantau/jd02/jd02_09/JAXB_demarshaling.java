package by.it.shkantau.jd02.jd02_09;

import by.it.shkantau.jd02.jd02_09.generatedAirport.Airport;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JAXB_demarshaling {
    private final static String  xmlFileName = "D:\\study\\Java\\PVT\\JavaProjects\\JD2016-08-22\\src\\by\\it\\shkantau\\jd02\\jd02_09\\airportXSD.xml";

    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(Airport.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            FileReader reader = new FileReader(xmlFileName);
            System.out.println("XML is read");
            Airport airport = (Airport) unmarshaller.unmarshal(reader);
            System.out.println(airport);

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println("File: "+ xmlFileName + "not found. "+ e);
        }
    }
}
