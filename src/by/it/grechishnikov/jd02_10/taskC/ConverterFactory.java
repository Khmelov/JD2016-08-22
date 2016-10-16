package by.it.grechishnikov.jd02_10.taskC;

import java.io.File;

class ConverterFactory {
    static AbstractConverter createConverter(Direction direction, String text) {
        if(direction == Direction.JSON_TO_XML) {
            return new ConvertToXml(text);
        } else if(direction == Direction.XML_TO_JSON) {
            return new ConvertToJson(text);
        }
        return null;
    }

    static AbstractConverter createConverter(Direction direction, File file) {
        if(direction == Direction.JSON_TO_XML) {
            return new ConvertToXml(file);
        } else if(direction == Direction.XML_TO_JSON) {
            return new ConvertToJson(file);
        }
        return null;
    }
}
