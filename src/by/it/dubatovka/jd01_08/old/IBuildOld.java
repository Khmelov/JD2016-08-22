package by.it.dubatovka.jd01_08.old;

/**
 * Created by Dubatovka Sergey on 17.09.2016.
 */
public interface IBuildOld {
    
    void buildNew(int area);

    void destroy();

    void repair();

    void setAdress(String adress);

    void getAdress();

    double getBuildingArea();

    void cataclysm();

}
