package by.it.grechishnikov.jd02_10.taskC;

import by.it.grechishnikov.jd02_10.Person;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.*;

class ConvertToJson extends AbstractConverter {
    ConvertToJson(String text) {
        super(text);
    }

    ConvertToJson(File path) {
        super(path);
        newPath = new File(path.toString().substring(0, path.toString().lastIndexOf(".")) + ".json");
    }

    @Override
    public void convertAndPrintResult() {
        checkText();
        String result = convertToString();
        System.out.println("Конвертация в JSON:\n" + result);
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
        //конвертация из xml в json
        convertToObject();
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        return gson.toJson(object);
    }

    @Override
    void convertToObject() {
        try {
            JAXBContext context = JAXBContext.newInstance(Person.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StringReader reader = new StringReader(text);
            object = (Person) unmarshaller.unmarshal(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}