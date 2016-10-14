package by.it.akhmelev.jd02_10.Converter;

import java.io.*;

abstract class AbstractConverter<T> {
    //тут данные, т.е. сам bean
    T bean;
    //поле класса нужно на случай, когда bean = null;
    private Class beanClass;
    //можно обойти этот недостаток, но довльно сложно:
    //https://habrahabr.ru/post/66593/

    AbstractConverter(Class beanClass) {
        bean = null;
        this.beanClass=beanClass;
    }

    AbstractConverter(T bean) {
        this.bean = bean;
        this.beanClass=bean.getClass();
    }

    T getBean() {
        return bean;
    }

    Class getBeanClass() {
        return beanClass;
    }

    //построение по данным из строки
    abstract public void buildConverter(String txtData);

    //запись результата в строку
    abstract public String getConverterResult();

    //построение по данным из файла
    //метод не абстрактный, т.к. одинаков для всех)
    void buildConverter(File file){
        String txtData = "";
        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                txtData = txtData.concat(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        //специализированный builder (тот что здесь абстрактный)
        buildConverter(txtData);
    }

    //запись результата в файл
    //метод не абстрактный, т.к. одинаков для всех)
    void saveConverterResultToFile(File endFile) {
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(
                             new FileWriter(endFile))) {
            bufferedWriter.write(
                    //специализированный конвертер (тот что здесь абстрактный)
                    getConverterResult()
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
