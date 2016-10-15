package by.it.aborisenok.JD02_08;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
/**
 * Created by Лёша on 15.10.2016.
 */
public class DOM {
    public static void main(String[] args) {
        String fileName = "D:\\JavaProjects\\JD2016-08-22\\src\\by\\it\\aborisenok\\JD02_07\\XML+XSD.xml";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(fileName);
            Element el=doc.getDocumentElement();
            printDom("", el);
        } catch (Exception e){

        }
    }

//    private static void printDom(String prefix, Node nodes) {
//        System.out.println(nodes.getNodeName());
//        NodeList nodeList = nodes.getChildNodes();
//        System.out.println(nodeList.getLength());
//        for (int i = 0; i < nodeList.getLength(); i++) {
//            System.out.println("=");
//            Node node = nodeList.item(i);
//            System.out.println(node.getNodeName());
////        }
////    }

    private static void printDom(String prefix, Node node) {
        String text = node.getNodeValue();
        System.out.println(text);
        if (text != null) {
            System.out.println(prefix + text.trim());
        }
        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            printDom(prefix + node.getNodeName() + " > ", children.item(i));
        }
    }
}
