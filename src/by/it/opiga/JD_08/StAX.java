package by.it.opiga.JD_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;

/**
 * Created by Asus on 16.10.2016.
 */
public class StAX {
    static String tab="";

    public static void main(String[] args) {
        try {
            String fileName="D:\\JAVA\\study\\JD2016-08-22\\src\\by\\it\\opiga\\JD_07\\xml+xsd.xml";
            FileInputStream input=new FileInputStream(fileName);
            XMLInputFactory inputFactory=XMLInputFactory.newInstance();
            XMLStreamReader reader=inputFactory.createXMLStreamReader(input);
            //пуск парсера
            String el="";
            while (reader.hasNext())
            {
                int type=reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                    {
                        System.out.println(tab+"<"+reader.getLocalName()+">");
                        tab=tab+"\t";
                        break;
                    }
                    case XMLStreamConstants.CHARACTERS:
                    {
                        el=el.concat(reader.getText().trim());
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT:
                    {
                        if(!el.isEmpty())
                            System.out.println(tab+el);
                        tab=tab.substring(1);
                        el="";
                        System.out.println(tab+"</"+reader.getLocalName()+">");
                        break;
                    }

                }
            }
        }catch (Exception e)
        {
            System.out.println("ошибка "+e.getMessage());
        }





    }







}
