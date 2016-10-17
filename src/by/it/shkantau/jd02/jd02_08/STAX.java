package by.it.shkantau.jd02.jd02_08;

import by.it.shkantau.jd02.jd02_07.homework.XSDValidator;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class STAX {
    private static StringBuilder tab = new StringBuilder();
    private static StringBuilder text = new StringBuilder();
    public static void main(String[] args) {
        try {
            FileInputStream   input = new FileInputStream(XSDValidator.xmlFileName);
            XMLInputFactory inputFactory = XMLInputFactory.newFactory();
            XMLStreamReader reader = inputFactory.createXMLStreamReader(input);

            while (reader.hasNext()){
                int type = reader.next();
                switch (type){
                    case XMLStreamConstants.START_ELEMENT:{
                        System.out.println(tab+"[" + reader.getLocalName() + "]");
                        tab.append("\t");
                        break;
                    }
                    case XMLStreamConstants.CHARACTERS:{
                        text.append(reader.getText().replaceAll("\n","").trim());
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT:{
                        if (!text.toString().isEmpty()){
                            System.out.println(tab.toString() + text);
                        }
                        tab = tab.delete(0,1);
                        text = new StringBuilder();
                        System.out.println(tab+"[/" + reader.getLocalName() + "]");
                        break;
                    }
                }

            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
