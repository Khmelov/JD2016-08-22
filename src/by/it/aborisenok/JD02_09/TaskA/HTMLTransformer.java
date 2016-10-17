package by.it.aborisenok.JD02_09.TaskA;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * Created by Лёша on 15.10.2016.
 */
public class HTMLTransformer {
    final static String root = "src/by/it/aborisenok/JD02_09/TaskA/";
    public static void main(String[] args) {
        String fileName = root + "XML.xml";
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer(new StreamSource(root + "XSL.xsl"));
            transformer.transform(new StreamSource(root + "XML.xml"),
                                    new StreamResult(root + "HTML.html"));
            System.out.println("Transform " + fileName + " complete");
        } catch (TransformerException e) {
            System.err.println("Impossible transform file " + fileName + " : " + e);
        }
    }
}
