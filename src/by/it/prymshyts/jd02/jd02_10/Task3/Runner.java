package by.it.prymshyts.jd02.jd02_10.Task3;

import java.io.File;

class Runner {
    private static String jsonFileName = "json_data.json";
    private static String xmlFileName  = "catalog.xml";

    private static String mainDir = System.getProperty("user.dir");
    private static String fileDir = mainDir + "/src/by/it/prymshyts/jd02/jd02_10/Task3/";
    private static String xmlDir  = fileDir + xmlFileName;
    private static String jsonDir = fileDir + jsonFileName;


    public static void main(String[] args) {
        Converter converter = ConverterFactory.getConverter(ConverterFactory.Dir.XML2JSON, Catalog.class);
        converter.buildConverter(new File(xmlDir));

        String JSON = converter.getConverterResult();
        System.out.println("XML-file to JSON-file:\n");
        System.out.println(JSON);

        converter.saveConverterResultToFile(new File(jsonDir));


        converter = ConverterFactory.getConverter(ConverterFactory.Dir.JSON2XML, Catalog.class);
        converter.buildConverter(new File(jsonDir));

        String XML = converter.getConverterResult();
        System.out.println("JSON-file to XML-file:\n");
        System.out.println(XML);


        converter.buildConverter(JSON);
        XML = converter.getConverterResult();
        System.out.println("JSON-text to XML-text");
        System.out.println(XML);
    }
}
