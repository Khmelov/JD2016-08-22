package by.it.akhmelev.jd02_10.Converter;

class ConverterFactory {
    private enum Direction{
        XML_TO_JSON, JSON_TO_XML
    }

    AbstractConverter createConverterBuilder(String typeParser, Class beanClass){
        Direction direction=Direction.valueOf(typeParser.toUpperCase());
        switch (direction) {
            case XML_TO_JSON:
            {
                return new ConverterXmlToJsonBuilder(beanClass);
            }
            case JSON_TO_XML:
            {
                return new ConverterJsonToXmlBuilder(beanClass);
            }
            default: throw new EnumConstantNotPresentException(
                    direction.getDeclaringClass(),direction.name()
            );
        }
    }
}
