package by.it.prymshyts.jd02.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;

class StAX {

    static private String tab = "";

    static void parse(String fileName) {
        try {
            FileInputStream inputStream  = new FileInputStream(fileName);
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            XMLStreamReader reader       = inputFactory.createXMLStreamReader(inputStream);

            String str = "";

            while (reader.hasNext()) {
                int type = reader.next();

                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        System.out.println(tab + '<' + reader.getLocalName() + '>');
                        tab += '\t';
                        break;

                    case XMLStreamConstants.ATTRIBUTE:
                        System.out.print(" " + reader.getAttributeLocalName(type) + "=" + reader.getAttributeValue(type));
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        str = str.concat(reader.getText().trim());
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        if (!str.isEmpty()) {
                            System.out.println(tab + str);
                        }
                        tab = tab.substring(1);
                        str = "";
                        System.out.println(tab + "</" + reader.getLocalName() + '>');
                        break;
                }
            }
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
