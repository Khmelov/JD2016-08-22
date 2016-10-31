package by.it.filimonchik.jd02_10.Task_B;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;

/**
 * Created by Raman.Filimonchyk on 28/10/2016.
 */
    class XMLtoJSON {
    public static void XMLJSON(){
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

        try{
            JAXBContext jaxbContext=JAXBContext.newInstance(ArendaAuto.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            FileReader reader = new FileReader("src/by/it/filimonchik/JD02_09/Task_B/auto.xml");
            ArendaAuto arendaAuto = (ArendaAuto) unmarshaller.unmarshal( reader );
            String json = gson.toJson(arendaAuto);
            System.out.println(json);
        }catch (Exception e) {
            System.out.println( "Ошибка" );
        }
    }
}
