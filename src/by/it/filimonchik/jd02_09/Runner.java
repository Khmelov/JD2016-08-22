package by.it.filimonchik.jd02_09;

import by.it.filimonchik.jd02_09.Task_A.XMLtoHTML;
import by.it.filimonchik.jd02_09.Task_B.fromXML;
import by.it.filimonchik.jd02_09.Task_B.toXML;

import javax.xml.bind.JAXBException;
import javax.xml.transform.TransformerException;
import java.io.FileNotFoundException;

/**
 * Created by Raman.Filimonchyk on 23/10/2016.
 */
public class Runner {
public static void main (String [] args) throws TransformerException, JAXBException, FileNotFoundException {
        XMLtoHTML.Task_A();
        toXML.Task_B();
        fromXML.Task_B();

}
}
