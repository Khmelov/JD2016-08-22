package by.it.filimonchik.jd02_08;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;

/**
 * Created by Raman.Filimonchyk on 21/10/2016.
 */
public class Runner {
    public static void main (String [] args) throws SAXException, IOException, XMLStreamException, ParserConfigurationException {
        System.out.println("Задание А.");
        SAX.Task_A_SAX();
        System.out.println("Задание B.");
        StaX.Task_B_StAX();
        System.out.println("Задание C.");
        DOM.Task_C_DOM();
    }
}
