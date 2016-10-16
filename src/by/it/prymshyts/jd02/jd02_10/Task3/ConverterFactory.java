package by.it.prymshyts.jd02.jd02_10.Task3;

class ConverterFactory {

    enum Dir {
        XML2JSON,
        JSON2XML
    }

    static Converter getConverter(Dir type, Class beanClass) {
        switch (type) {
            case XML2JSON:
                return new ConverterXML2JSON(beanClass);

            case JSON2XML:
                return new ConverterJSON2XML(beanClass);

            default:
                throw new EnumConstantNotPresentException(
                        type.getDeclaringClass(), type.name());
        }
    }
}
