package by.it.voronovich.JD02_10.Task_B;

import javax.xml.bind.JAXBException;
import java.io.IOException;

import static by.it.voronovich.JD02_10.Task_B.Converter.Converter.*;

public class Runner {

    public static void main(String[] args) {
        //Произведем конвертацию XML > JAXB > JSON
        String filePath = "src/by/it/voronovich/JD02_10/Task_B/Converter/WebStore.xml";
        try {
            JAXB_toJSON(XML_toJAXB(filePath)) ;
        } catch(JAXBException| IOException e){
            e.printStackTrace();
        }

        //Произведем конвертацию   JSON > JAXB > XML
        try{
            JAXB_toXML(JSON_toJAXB(JAXB_toJSON(XML_toJAXB(filePath))));
        } catch(JAXBException | IOException e){
            e.printStackTrace();
        }
    }
}
