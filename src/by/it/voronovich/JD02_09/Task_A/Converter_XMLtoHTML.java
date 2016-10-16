package by.it.voronovich.JD02_09.Task_A;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Converter_XMLtoHTML {

    public static void main(String args[]) {
        try {
            TransformerFactory tFactory = TransformerFactory.newInstance();

            Source xslDoc = new StreamSource("src/by/it/voronovich/JD02_09/Task_A/WebStore.xsl");
            Source xmlDoc = new StreamSource("src/by/it/voronovich/JD02_07/WebStore.xml");

            String outputFileName = "src/by/it/voronovich/JD02_09/Task_A/WebStore.html";

            OutputStream htmlFile = new FileOutputStream(outputFileName);
            Transformer trasform = tFactory.newTransformer(xslDoc);
            trasform.transform(xmlDoc, new StreamResult(htmlFile));
        } catch (FileNotFoundException | TransformerFactoryConfigurationError | TransformerException e) {
            e.printStackTrace();
        }
    }
}
