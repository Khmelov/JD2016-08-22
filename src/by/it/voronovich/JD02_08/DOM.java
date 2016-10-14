package by.it.voronovich.JD02_08;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DOM {

    public static void main(String[] args) throws IOException, SAXException {
        String src = System.getProperty("user.dir") + "/src/";
        String filePath = src + "by/it/voronovich/jd02_07/Structure_Webstore.xml";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(filePath);
            Element element = document.getDocumentElement();
            String xml = printDOM(element);
            System.out.println(xml);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.print("Ошибка! " + e.getMessage());
        }
    }

    private static StringBuilder sb = new StringBuilder();
    private static String tab = "";

    private static String printDOM(Node node) {
        sb.append(tab).append("<").append(node.getNodeName());
        NamedNodeMap attributes = node.getAttributes();
        for (int i = 0; i < attributes.getLength(); i++) {
            Node attribute = attributes.item(i);
            sb.append(" ").append(attribute.getNodeName()).append("=\"").append(attribute.getNodeValue()).append("\"");
        }
        sb.append(">\n");
        tab = tab + "\t";
        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            if (children.item(i) instanceof Element) {
                printDOM(children.item(i));
            } else {
                String text = children.item(i).getTextContent().trim();
                if (!text.isEmpty()) {
                    sb.append(tab).append(text).append("\n");
                }
            }
        }
        tab = tab.substring(1);
        sb.append(tab).append("</").append(node.getNodeName()).append(">\n");
        return sb.toString();
    }
}