package by.it.grechishnikov.jd02_09.taskA;


import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class Runner {
    private static String path = "src/by/it/grechishnikov/jd02_07/";

    public static void main(String[] args) {
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer(new StreamSource("src/by/it/grechishnikov/jd02_09/taskA/Store.xsl"));
            transformer.transform(new StreamSource(path + "Store.xml"), new StreamResult(path + "xpath.html"));
            System.out.println("complete");
        } catch (Exception e) {

        }
    }
}
