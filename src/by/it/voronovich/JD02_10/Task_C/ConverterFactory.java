package by.it.voronovich.JD02_10.Task_C;

public class ConverterFactory {
    private enum Direction {
        XML_TO_JSON, JSON_TO_XML
    }

    public AbstractConverter createConverterBuilder(String typeParser, Class beanClass) {
        Direction direction = Direction.valueOf(typeParser.toUpperCase());
        switch (direction) {
            case XML_TO_JSON:
            {
                return new ConverterXMLtoJSONBuilder(beanClass);
            }
            case JSON_TO_XML:
            {
                return new ConverterJSONtoXMLBuilder(beanClass);
            }
            default: throw new EnumConstantNotPresentException(
                    direction.getDeclaringClass(), direction.name()
            );
        }
    }
}