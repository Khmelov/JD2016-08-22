package by.it.prymshyts.jd02.jd02_08;


import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

class DOM {

    private static String tab = "";

    static void parse(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder  = factory.newDocumentBuilder();
            Document document        = builder.parse(fileName);
            Element element          = document.getDocumentElement();

            printDOM(element);
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void printDOM(Node node) {

        if (node.getNodeType() == Node.ELEMENT_NODE) {
            System.out.print(tab + "<" + node.getNodeName());

            NamedNodeMap attributes = node.getAttributes();

            if (attributes != null) {
                for (int i = 0; i < attributes.getLength(); i++) {
                    Node attribute = attributes.item(i);
                    System.out.print(" " + attribute.getNodeName() + "=\"" + attribute.getNodeValue() + "\"");
                }
            }

            System.out.println(">");
        }

        tab += '\t';

        NodeList childNodes = node.getChildNodes();

        if(childNodes.getLength() > 0) {
            for (int i = 0; i < childNodes.getLength(); i++) {
                printDOM(childNodes.item(i));
            }
        } else {
            if(node.getNodeValue() != null && !node.getNodeValue().trim().isEmpty()) {
                System.out.println(tab.substring(1) + node.getNodeValue().trim());
            }
        }

        tab = tab.substring(1);

        if(node.getNodeType() == Node.ELEMENT_NODE) {
            System.out.println(tab + "</" + node.getNodeName() + ">");
        }
    }
}
