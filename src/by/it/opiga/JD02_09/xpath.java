package by.it.opiga.JD02_09;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

/**
 * Created by Ольга on 17.10.2016.
 */
public class xpath {
    final static String root="D:\\JAVA\\study\\JD2016-08-22\\src\\by\\it\\opiga\\JD02_09\\";

    public static void main(String[] args) {
       // String fileName=root+"orders.xml";
        File xslFile = new File("D:\\JAVA\\study\\JD2016-08-22\\src\\by\\it\\opiga\\JD02_09\\xpath.xsl");
        File xslFile2 = new File("D:\\JAVA\\study\\JD2016-08-22\\src\\by\\it\\opiga\\JD02_09\\orders.xml");
        try{
            TransformerFactory tf=TransformerFactory.newInstance();
            Transformer transformer=tf.newTransformer(new StreamSource(xslFile));
            transformer.transform(new StreamSource(xslFile2),new StreamResult(root+"orders.html"));
            System.out.println("Transform "+xslFile2+" complete");
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }


}
