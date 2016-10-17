package by.it.shkantau.jd02.jd02_09.xslTaskA;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XMLtoHTML {

    private final static String path = "D:\\study\\Java\\PVT\\JavaProjects\\JD2016-08-22\\src\\by\\it\\shkantau\\jd02\\jd02_09\\xslTaskA\\";
    public static void main(String[] args) {

        String fileNameXML = path + "airport.xml";
        String fileNameHTML = path + "airport.html";

        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(path + "airport.xsl"));
            transformer.transform(new StreamSource(fileNameXML), new StreamResult(fileNameHTML));
            System.out.println("Transform complete");

        }catch (TransformerException e) {
            System.out.println("Wrong transform file "+ fileNameXML + " : " + e);
        }
    }
}
