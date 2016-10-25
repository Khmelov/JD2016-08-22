package by.it.filimonchik.jd02_09.Task_A;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * Created by Raman.Filimonchyk on 23/10/2016.
 */
public class XMLtoHTML {
    final static String root="src/by/it/filimonchik/jd02_09/Task_A/";
    public static void Task_A() throws TransformerException{
        String fileName=root+"starter.xml";
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer(new StreamSource(root + "auto.xsl"));
            transformer.transform( new StreamSource( root + "auto.xml"),
                    new StreamResult( root + "auto.html"));
            System.out.println("Transform " + fileName + " complete");
        }
        catch (TransformerException e){
            System.out.println(" Transformer error");
        }
    }
}
