package by.it.aborisenok.JD02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;


/**
 * Created by Лёша on 12.10.2016.
 */
public class StAX {
    static String tab = "";

    public static void main(String[] args) {
        try {
            String fileName = "D:\\JavaProjects\\JD2016-08-22\\src\\by\\it\\aborisenok\\JD02_07\\XML+XSD.xml";

            FileInputStream inputStream = new FileInputStream(fileName);
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            XMLStreamReader reader = inputFactory.createXMLStreamReader(inputStream);
            String el = "";
            while (reader.hasNext()){
                int type = reader.next();
                switch (type){
                    case XMLStreamReader.START_ELEMENT:
                    {
                        System.out.println(tab + "<" + reader.getLocalName() + ">");
                        tab = tab + "\t";
                        break;
                    }
                    case XMLStreamConstants.CHARACTERS:
                    {
                        el = el.concat(reader.getText().trim());
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT:
                    {
                        if (!el.isEmpty())
                            System.out.println(tab+el);
                            tab = tab.substring(1);
                        el = "";
                        System.out.println(tab + "</" + reader.getLocalName() + ">");
                        break;
                    }
                }
            }
    } catch (Exception e){
            System.out.println("Error " + e.toString());
        }

    }
}
