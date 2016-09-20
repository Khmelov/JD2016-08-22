package by.it.grechishnikov.jd01_13;

import by.it.grechishnikov.jd01_08.NotSupportedOperationException;
import by.it.grechishnikov.jd01_08.SeniorLead;

public class TaskC {
    static void start() {
        try {
            SeniorLead.cleanToilet();
        } catch (NotSupportedOperationException e) {
            System.err.println(e.getMessage());
        } finally {
            System.err.println("Для этого есть уборщики!");
        }
    }
}
