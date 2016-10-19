package by.it.snegurskiy.jd02_07.xml_class;


import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class STAX {
    static String tab="";
    public static void main(String[] args) {
        try {
            String filename ="src/by/it/snegurskiy/jd02_07/xml_class/ad+xsd.xml";
            FileInputStream inputStream  = new FileInputStream(filename);
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }

    }

}
