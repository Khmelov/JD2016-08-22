package by.it.grechishnikov.jd02_08;


import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class DOM {
    public static void run(String path) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(path);
            Element el = doc.getDocumentElement();
            printDom("", el, "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printDom(String prefix, Node node, String attributes) {
        String text = node.getNodeValue();
        if(text != null) {
            text = text.trim();
            if(!text.isEmpty()) {
                text = " \"" + text + "\"";
            }
            System.out.println(prefix + text + attributes);
        }
        NamedNodeMap attributesMap = node.getAttributes();
        attributes = "";
        if(attributesMap != null) {
            for (int i = 0; i < attributesMap.getLength(); i++) {
                attributes += " " + attributesMap.item(i).getNodeName() + " = \"" + attributesMap.item(i).getNodeValue() + "\"";
            }
        }
        NodeList list = node.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            printDom(prefix + "[" + node.getNodeName() + "]", list.item(i), attributes);
        }
    }
}
