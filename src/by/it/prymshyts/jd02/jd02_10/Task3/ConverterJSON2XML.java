package by.it.prymshyts.jd02.jd02_10.Task3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

@SuppressWarnings("ALL")
class ConverterJSON2XML extends Converter {

    ConverterJSON2XML(Class beanClass) {
        super(beanClass);
    }

    ConverterJSON2XML(Object bean) {
        super(bean);
    }

    @Override
    void buildConverter(String txt) {
        Gson GSON = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        this.setBean(GSON.fromJson(txt, this.getBeanClass()));
    }

    @Override
    String getConverterResult() {
        StringWriter writer = new StringWriter();

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(getBeanClass());
            Marshaller marshaller   = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(getBean(), writer);

        } catch (JAXBException e) {
            System.err.println("Ошибка маршализации XML.");
            e.printStackTrace();
        }

        return writer.toString();
    }
}
