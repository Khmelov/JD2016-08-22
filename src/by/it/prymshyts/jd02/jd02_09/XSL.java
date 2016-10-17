package by.it.prymshyts.jd02.jd02_09;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

class XSL {
    private final static String filePathMain = "src/by/it/prymshyts/jd02/jd02_09/";
    private final static String filePathXSL  = filePathMain + "catalog.xsl";
    private final static String filePathHTML = filePathMain + "catalog.html";
    private final static String filePathXML  = filePathMain + "catalog.xml";

    public static void main(String[] args) {
        try {
            TransformerFactory tf   = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer(new StreamSource(filePathXSL));

            transformer.transform(new StreamSource(filePathXML),
                    new StreamResult(filePathHTML));

            System.out.println("Обработка завершена.");
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
