package by.it.opiga.JD_08;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by Asus on 16.10.2016.
 */
public class DOM {
    public static void main(String[] args) {
        String fileName = "D:\\JAVA\\study\\JD2016-08-22\\src\\by\\it\\opiga\\JD_07\\xml+xsd.xml";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            org.w3c.dom.Document doc = builder.parse(fileName);
            org.w3c.dom.Element el = doc.getDocumentElement();
            printDom("", el);

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printDom(String prefix, Node node) {
        String text = node.getNodeValue();
        if (text != null)
            System.out.println(prefix + text.trim());

        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            printDom(prefix + node.getNodeName() + ">", children.item(i));
        }

    }


}



