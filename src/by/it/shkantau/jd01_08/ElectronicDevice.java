package by.it.shkantau.jd01_08;

/**
 * Created by Aliaksei on 13.09.2016.
 */
public interface ElectronicDevice {
    String getName();
    double getWeight();
    void switchOn();
    void switchOf();
    void plugPower(int voltage);
    void repair();
    int getSupplyVoltage();
    double getDemand();
    String toString();





}
