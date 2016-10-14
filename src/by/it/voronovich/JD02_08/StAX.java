package by.it.voronovich.JD02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.InputStream;

public class StAX {

    private static String tab = "";

    public static void main(String[] args) {

        String filePath = "src/by/it/voronovich/JD02_07/Structure_WebStore.xml";

        try {
            InputStream input = new FileInputStream(filePath);
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
            String el = "";
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT: {
                        System.out.print(tab + "<" + reader.getLocalName());
                        tab = tab + "\t";
                        int countAttr = reader.getAttributeCount();
                        for (int i = 0; i < countAttr; i++) {
                            System.out.print(" " + reader.getAttributeLocalName(i) + "=");
                            System.out.print("\"" + reader.getAttributeValue(i) + "\"");
                        }
                        System.out.println(">");
                        break;
                    }
                    case XMLStreamConstants.CHARACTERS: {
                        el = el.concat(reader.getText().trim());
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT: {
                        if (!el.isEmpty())
                            System.out.println(tab + el);
                        tab = tab.substring(1);
                        el = "";
                        System.out.println(tab + "</" + reader.getLocalName() + ">");
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.print("Ошибка! " + e.toString());
        }
    }
}
