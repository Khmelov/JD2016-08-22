package by.it.grechishnikov.jd02_10.taskC;

import java.io.File;

public class Runner {
    public static void main(String[] args) {
        String fileName = "/Users/Evgeniy/Documents/java/JD2016-08-22/src/by/it/grechishnikov/jd02_10/taskC/test.json";
        //Из файла (для .json создается такой же файл с разрешение .xml и наоборот)
        Direction direction = null;
        if(fileName.endsWith(".xml")) {
            direction = Direction.XML_TO_JSON;
        } else {
            direction = Direction.JSON_TO_XML;
        }
        AbstractConverter converter = ConverterFactory.createConverter(direction, new File(fileName));
        converter.convertAndPrintResult();


        //Из строки (вывод на консоль)
        converter = ConverterFactory.createConverter(Direction.JSON_TO_XML,
                "{\"firstName\": \"Ivan\",\n" +
                        "  \"lastName\": \"Ivanov\",\n" +
                        "  \"age\": 30}");
        converter.convertAndPrintResult();

        converter = ConverterFactory.createConverter(Direction.XML_TO_JSON,
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                        "<person>\n" +
                        "    <age>20</age>\n" +
                        "    <firstName>Petr</firstName>\n" +
                        "    <lastName>Petrov</lastName>\n" +
                        "</person>");
        converter.convertAndPrintResult();
    }
}
