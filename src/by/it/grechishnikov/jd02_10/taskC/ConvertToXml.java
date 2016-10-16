package by.it.grechishnikov.jd02_10.taskC;

import by.it.grechishnikov.jd02_10.Person;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.*;

class ConvertToXml extends AbstractConverter {
    ConvertToXml(String text) {
        super(text);
    }

    ConvertToXml(File path) {
        super(path);
        newPath = new File(path.toString().substring(0, path.toString().lastIndexOf(".")) + ".xml");
    }

    @Override
    public void convertAndPrintResult() {
        checkText();
        String result = convertToString();
        System.out.println("Конвертация в XML:\n" + result);
        if(newPath != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(newPath))) {
                writer.write(result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    String convertToString() {
        //конвертация из json в xml
        convertToObject();
        try {
            JAXBContext context = JAXBContext.newInstance(Person.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter writer = new StringWriter();
            marshaller.marshal(object, writer);
            return writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    void convertToObject() {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        object = gson.fromJson(text, Person.class);
    }
}