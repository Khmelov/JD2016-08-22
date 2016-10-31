package by.it.filimonchik.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by Raman.Filimonchyk on 21/10/2016.
 */
public class StaX {
    public static void Task_B_StAX() throws FileNotFoundException, XMLStreamException {
    String tab="";
        try {
            String fileName = "src/by/it/filimonchik/jd02_07/auto+xsd.xml";
            FileInputStream input = new FileInputStream(fileName);
            XMLInputFactory inputFactory=XMLInputFactory.newInstance();
            XMLStreamReader streamReader=inputFactory.createXMLStreamReader(input);
            String el="";
            while (streamReader.hasNext()){
                int type=streamReader.next();
                switch (type){
                    case XMLStreamConstants.START_ELEMENT:{
                        System.out.println(tab + "[" + streamReader.getLocalName() + "]");
                        tab=tab+"\t";
                        break;
                    }
                    case XMLStreamConstants.CHARACTERS:{
                        el=el.concat(streamReader.getText().trim());
                        break;
                    }
                    case  XMLStreamConstants.END_ELEMENT:{
                        if(!el.isEmpty())
                            System.out.println(tab + el);
                        tab=tab.substring(1);
                        el="";
                        System.out.println(tab + "[" + streamReader.getLocalName() + "]");
                        break;
                    }
                }
            }System.out.println("");
        }catch (Exception e){
            System.out.print("Ошибка");
        }
    }
}
