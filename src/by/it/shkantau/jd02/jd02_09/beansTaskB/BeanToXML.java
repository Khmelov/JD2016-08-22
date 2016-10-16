package by.it.shkantau.jd02.jd02_09.beansTaskB;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

public class BeanToXML {

    private static String path = "D:\\study\\Java\\PVT\\JavaProjects\\JD2016-08-22\\src\\by\\it\\shkantau\\jd02\\jd02_09\\beansTaskB\\";
    private static String fileName = "inputParameter.xml";

    public static void main(String[] args) {

        InputParameterListWrapper parameters = createBeanInstance();
        marshling(path + fileName, parameters);
        demarshling(path + fileName);

    }

    private static InputParameterListWrapper createBeanInstance() {
        InputParameterListWrapper parameters = new InputParameterListWrapper();
        parameters.getParameterListWrapper().add(new Parameter("itemperature", 0 , 2, "Temperature of the environment"));
        parameters.getParameterListWrapper().add(new Parameter("iUre", 2 , 2, "Complex Voltage"));
        parameters.getParameterListWrapper().add(new Parameter("iIre", 4 , 2, "Complex Current"));
        parameters.getParameterListWrapper().add(new Parameter("iP", 6 , 2, "Pressure"));
        return parameters;
    }

    private static void marshling(String fileName , InputParameterListWrapper parameters){
        try {
            JAXBContext context = JAXBContext.newInstance(InputParameterListWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(parameters, new FileOutputStream(fileName));
            System.out.println("Bean stored to XML.");

        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void demarshling(String fileName) {
        try {
            JAXBContext context = JAXBContext.newInstance(InputParameterListWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            InputParameterListWrapper paramFromXML = (InputParameterListWrapper)unmarshaller.unmarshal(new FileReader(fileName));
            System.out.println("Bean created form XML:\n"+paramFromXML);
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
