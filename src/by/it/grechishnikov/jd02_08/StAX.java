package by.it.grechishnikov.jd02_08;


import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;

class StAX {
    private static String tab = "";
    private static StringBuilder text = new StringBuilder("");
    public static void run(String path) {
        try {
            FileInputStream stream = new FileInputStream(path);
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader streamReader = factory.createXMLStreamReader(stream);

            while (streamReader.hasNext()) {
                int value = streamReader.next();//исключение
                check(value, streamReader);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void check(int value, XMLStreamReader streamReader) {
        switch (value) {
            case XMLStreamConstants.START_ELEMENT :
                System.out.println(tab + "[" + streamReader.getLocalName() + "]");
                tab += "\t";
                break;
            case XMLStreamConstants.CHARACTERS :
                text.append(streamReader.getText().trim());
                break;
            case XMLStreamConstants.END_ELEMENT :
                if(text.length() != 0) {
                    System.out.println(tab + text);
                }
                text.delete(0, text.length());
                tab = tab.substring(1);
                System.out.println(tab + "[/" + streamReader.getLocalName() + "]");
                break;
        }
    }
}
