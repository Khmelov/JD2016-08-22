package by.it.dubatovka.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class StAX_parser {
    private static String tab = "";

    public static void main(String[] args) {

        String fileName = "src/by/it/dubatovka/jd02_07/VulkanXSD.xml";
        FileInputStream inputStream;
        try {
            inputStream = new FileInputStream(fileName);
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            XMLStreamReader reader = inputFactory.createXMLStreamReader(inputStream);
            String element = "";
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT: {
                        System.out.println(tab + "<" + reader.getLocalName() + ">");
                        tab += "\t";
                        break;
                    }
                    case XMLStreamConstants.CHARACTERS: {
                        element = element.concat(reader.getText().trim());
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT: {
                        if (!element.isEmpty()) {
                            System.out.println(tab + element);
                        }
                        tab = tab.substring(1);
                        element = "";
                        System.out.println(tab + "</" + reader.getLocalName() + ">");
                        break;
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            System.out.println("Error! " + e.toString());
            e.printStackTrace();
        }
    }
}
