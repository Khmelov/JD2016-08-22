package by.it.voronovich.JD02_10.Task_C;

import java.io.File;

public class Runner {
    public static void main(String[] args) {
        File file;
        String src=System.getProperty("user.dir")+"/src/by/it/voronovich/";
        ConverterFactory converterFactory = new ConverterFactory();

        //из XML-файла в JSON-текст
        AbstractConverter<WebStore> converter =
                converterFactory.createConverterBuilder("xml_to_json",WebStore.class);
        file=new File(src+"JD02_10/Task_C/WebStore.xml");
        converter.buildConverter(file);
        String json=converter.getConverterResult();
        System.out.println("\nиз XML-файла в JSON-текст\n");
        System.out.println(json);

        //из JSON-файла в XML-текст
        converter = converterFactory.createConverterBuilder("json_to_xml",WebStore.class);
        file=new File(src+"JD02_10/Task_C/WebStore.json");
        converter.buildConverter(file);
        String xml=converter.getConverterResult();
        System.out.println("\nиз JSON-файла в XML-текст\n");
        System.out.println(xml);

        //из JSON-текста в XML-текст
        converter = converterFactory.createConverterBuilder("json_to_xml",WebStore.class);
        converter.buildConverter(json); //берем из предыдущего вызова конвертера
        xml=converter.getConverterResult();
        System.out.println("\nиз JSON-текста в XML-текст\n");
        System.out.println(xml);
    }
}