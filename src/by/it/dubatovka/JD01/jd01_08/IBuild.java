package by.it.dubatovka.JD01.jd01_08;

/**
 * Created by Dubatovka Sergey on 18.09.2016.
 */
interface IBuild {

    String getAddress();

    void open();

    void close();

    String info();

    int getFloor();

    boolean isOpen();


}
