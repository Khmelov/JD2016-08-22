package by.it.akhmelev.jd02_09.xpath;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XSL_04 {
    final static String root="src/by/it/akhmelev/jd02_09/xpath/";
    public static void main(String[ ] args) {
        String fileName=root+"xpath.xml";
        String fileHTML=root+"xpath.html";

        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            // установка используемого XSL-преобразования
            Transformer transformer = tf.newTransformer(new StreamSource(root+"xpath.xsl"));
            // установка исходного XML-документа и конечного XML-файла
            transformer.transform(new StreamSource(fileName),
                    new StreamResult(fileHTML));
            System.out.println("Transform " + fileName + " complete");
        } catch(TransformerException e) {
            System.err.println("Impossible transform file " + fileName + " : " + e);
        }
}
}
