package by.it.filimonchik.jd02_10.Task_B;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;

/**
 * Created by Raman.Filimonchyk on 29/10/2016.
 */
public class JSONtoXML {

    public static void JSONXML(){

        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance( ArendaAuto.class );
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            FileReader reader = new FileReader( "src/by/it/filimonchik/JD02_09/Task_B/auto.xml" );
            ArendaAuto arendaAuto = (ArendaAuto) unmarshaller.unmarshal( reader );
            String json = gson.toJson( arendaAuto );
            ArendaAuto dill = gson.fromJson( json, ArendaAuto.class );
                Marshaller marshaller = jaxbContext.createMarshaller();
                marshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );
                marshaller.marshal( dill, System.out );
            } catch (JAXBException e) {
                System.out.println( "JAXB-контекст ошибочен " + e );
            } catch (Exception e) {
                System.out.println( "Ошибка" );
            }
        }
    }
