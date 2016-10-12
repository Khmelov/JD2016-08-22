package by.it.voronovich.JD02_06;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

/**
 * Класс запускает тесты класса ParserTest.java и выводит на консоль результат
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */
public class RunParserTest {

    public static void main(String[] args) throws Exception {

        JUnitCore runner = new JUnitCore();
        Result result = runner.run(ParserTest.class);

        System.out.println("run tests: " + result.getRunCount());
        System.out.println("failed tests: " + result.getFailureCount());
        System.out.println("ignored tests: " + result.getIgnoreCount());
        System.out.println("success: " + result.wasSuccessful());
    }
}
