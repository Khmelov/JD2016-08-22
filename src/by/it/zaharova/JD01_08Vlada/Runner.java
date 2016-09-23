package by.it.zaharova.JD01_08Vlada;

import by.it.zaharova.JD01_08Vlada.AircraftCarrier;

/**
 * Created by user on 20.09.2016.
 */
public class Runner {
    public static void main(String[] args) {
        AircraftCarrier aircraftCarrier = new AircraftCarrier();
        aircraftCarrier.swimming();
        aircraftCarrier.showState();
        aircraftCarrier.setAmmo(50);
        aircraftCarrier.showState();
        aircraftCarrier.notswimming();
        aircraftCarrier.showState();
        aircraftCarrier.notswimming();
        aircraftCarrier.showState();
        aircraftCarrier.swimming();
        aircraftCarrier.showState();

    }
}
