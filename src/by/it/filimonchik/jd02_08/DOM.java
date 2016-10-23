package by.it.filimonchik.jd02_08;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by Raman.Filimonchyk on 23/10/2016.
 */
public class DOM {
        public static void Task_C_DOM() throws DOMException, ParserConfigurationException, IOException, SAXException {
            String fileName = "src/by/it/filimonchik/jd02_07/auto+xsd.xml";
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            try {
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.parse(fileName);
                Element el = doc.getDocumentElement();
                printDom("", el);
            }catch (DOMException e){
                System.out.println("Ошибка парсера");
            }

        }
        private static void printDom (String prefix, Node node){
        String text = node.getNodeValue();
            if(text!=null){
                System.out.println(prefix + text.trim());
            }
            NodeList children = node.getChildNodes();
            for(int i=0; i<children.getLength(); i++){
                printDom( prefix+node.getNodeName()+ " > ", children.item( i ) );
            }
        }
}
