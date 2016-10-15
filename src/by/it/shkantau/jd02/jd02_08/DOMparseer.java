package by.it.shkantau.jd02.jd02_08;

import by.it.shkantau.jd02.jd02_07.homework.XSDValidator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DOMparseer {

    public static void main(String[] args) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(XSDValidator.xmlFileName);
            Element element = document.getDocumentElement();
            printDOM_element("", element);

        }catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void printDOM_element(String prefix, Node node){
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            System.out.print(prefix + "<" + node.getNodeName());
            if (node.hasAttributes()) {
                for (int i = 0; i < node.getAttributes().getLength(); i++) {
                    System.out.print(" " + node.getAttributes().item(i));
                }
            }
            System.out.println(">");
            NodeList children = node.getChildNodes();
            prefix += "\t";
            for (int i = 0; i < children.getLength(); i++) {
                printDOM_element(prefix, children.item(i));
            }
            prefix = prefix.substring(1);
            System.out.print(prefix + "</" + node.getNodeName());
            System.out.println(">");
        }else if(!node.getNodeValue().replaceAll("\\s+","").isEmpty()) {
            System.out.println(prefix + node.getNodeValue());
        }
    }
}
