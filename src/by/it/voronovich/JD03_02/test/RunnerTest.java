package by.it.voronovich.JD03_02.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class RunnerTest {
    public static void main(String[] args) throws Exception {

        JUnitCore runner = new JUnitCore();
        Result result = runner.run(RoleCRUDTest.class, UserCRUDTest.class, CatalogGoodCRUDTest.class, OrderCRUDTest.class);

        System.out.println("run tests: " + result.getRunCount());
        System.out.println("failed tests: " + result.getFailureCount());
        System.out.println("ignored tests: " + result.getIgnoreCount());
        System.out.println("success: " + result.wasSuccessful());
    }
}
