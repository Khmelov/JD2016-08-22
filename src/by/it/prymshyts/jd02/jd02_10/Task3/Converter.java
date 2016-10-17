package by.it.prymshyts.jd02.jd02_10.Task3;

import java.io.*;

abstract class Converter<T> {

    private T bean;
    private Class beanClass;

    Converter(Class beanClass) {
        this.bean      = null;
        this.beanClass = beanClass;
    }

    Converter(T bean) {
        this.bean      = bean;
        this.beanClass = bean.getClass();
    }

    T getBean() {
        return bean;
    }

    void setBean(T bean) {
        this.bean = bean;
    }

    Class getBeanClass() {
        return beanClass;
    }

    void buildConverter(File file) {
        StringBuilder sb = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(
                new FileReader(file)
        )) {
            String str;
            while ((str = reader.readLine()) != null) {
                sb.append(str);
            }

        } catch (FileNotFoundException e) {
            System.err.println("Ошибка открытия файла.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла.");
            e.printStackTrace();
        }

        buildConverter(sb.toString());
    }

    void saveConverterResultToFile(File saveFile) {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(saveFile)
        )) {
            writer.write(getConverterResult());

        } catch (FileNotFoundException e) {
            System.err.println("Ошибка открытия файла.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Ошибка записи файла.");
            e.printStackTrace();
        }
    }

    abstract void buildConverter(String txt);
    abstract String getConverterResult();
}
