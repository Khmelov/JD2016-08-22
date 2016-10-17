package by.it.prymshyts.jd02.jd02_10.Task3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

@SuppressWarnings("ALL")
class ConverterXML2JSON extends Converter {

    ConverterXML2JSON(Class beanClass) {
        super(beanClass);
    }

    ConverterXML2JSON(Object bean) {
        super(bean);
    }

    @Override
    void buildConverter(String txt) {
        try {
            StringReader reader     = new StringReader(txt);
            JAXBContext jaxbContext = JAXBContext.newInstance(getBeanClass());

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            setBean(unmarshaller.unmarshal(reader));

        } catch (JAXBException e) {
            System.err.println("Ошибка демаршализации.");
            e.printStackTrace();
        }
    }

    @Override
    String getConverterResult() {
        Gson GSON = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        return GSON.toJson(getBean());
    }
}
