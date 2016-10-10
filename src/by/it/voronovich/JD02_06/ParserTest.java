package by.it.voronovich.JD02_06;

import by.it.voronovich.JD02_06.Operation.Calculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Класс содержит тесты на парсинг вычислительных операций
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */
public class ParserTest {

    @Test
    public void test1() throws Exception {
        String str = "A = 2 + 5.3";
        String result = new Calculator().calculator(str);
        assertEquals(result, "A = 7.3");
    }

    @Test
    public void test2() throws Exception {
        String str = "B = A * 3.5";
        String result = new Calculator().calculator(str);
        assertEquals(result, "B = 25.55");
    }

    @Test
    public void test3() throws Exception {
        String str = "B1 = B - 0.55";
        String result = new Calculator().calculator(str);
        assertEquals(result, "B1 = 25.0");
    }

    @Test
    public void test4() throws Exception {
        String str = "B2 = A / 2";
        String result = new Calculator().calculator(str);
        assertEquals(result, "B2 = 3.65");
    }

    @Test
    public void test5() throws Exception {
        String str = "C = B + (A * 2)";
        String result = new Calculator().calculator(str);
        assertEquals(result, "C = 40.15");
    }

    @Test
    public void test6() throws Exception {
        String str = "D = ((C - 0.15) - 20) / (7 - 5)";
        String result = new Calculator().calculator(str);
        assertEquals(result, "D = 10.0");
    }

    @Test
    public void test7() throws Exception {
        String str = "E = {2,3} * (D / 2)";
        String result = new Calculator().calculator(str);
        assertEquals(result, "E = {10.0,15.0}");
    }

    @Test
    public void floatAddFloat() throws Exception {
        String result = new Calculator().calculator("1 + 7");
        assertEquals("8.0", result);
    }

    @Test
    public void floatSubFloat() throws Exception {
        String result = new Calculator().calculator("1 - 9");
        assertEquals("-8.0", result);
    }

    @Test
    public void floatMultFloat() throws Exception {
        String result = new Calculator().calculator("10 * 7");
        assertEquals("70.0", result);
    }

    @Test
    public void floatDivFloat() throws Exception {
        String result = new Calculator().calculator("10 / 10");
        assertEquals("1.0", result);
    }

    @Test
    public void floatAddVector() throws Exception {
        String result = new Calculator().calculator("10 + {1,2,3}");
        assertEquals("{11.0,12.0,13.0}", result);
    }

    @Test
    public void vectorSubFloat() throws Exception {
        String result = new Calculator().calculator("{1,2,3} - 10");
        assertEquals("{-9.0,-8.0,-7.0}", result);
    }

    @Test
    public void vectorMulFloat() throws Exception {
        String result = new Calculator().calculator("{1,2,3} * 10");
        assertEquals("{10.0,20.0,30.0}", result);
    }

    @Test
    public void vectorDivFloat() throws Exception {
        String result = new Calculator().calculator("{1,2,3} / 10");
        assertEquals("{0.1,0.2,0.3}", result);
    }

    @Test
    public void vectorAddVector() throws Exception {
        String result = new Calculator().calculator("{1,2,3} + {1,2,4}");
        assertEquals("{2.0,4.0,7.0}", result);
    }

    @Test
    public void vectorSubVector() throws Exception {
        String result = new Calculator().calculator("{1,2,3} - {1,2,4}");
        assertEquals("{0.0,0.0,-1.0}", result);
    }

    @Test
    public void vectorMulVector() throws Exception {
        String result = new Calculator().calculator("{1,2,3} * {1,2,4}");
        assertEquals("17.0", result);
    }

    @Test
    public void matrixAddFloat() throws Exception {
        String result = new Calculator().calculator("{{1,2},{1,2}} + 1");
        assertEquals("{{2.0,3.0},{2.0,3.0}}", result);
    }

    @Test
    public void matrixSubFloat() throws Exception {
        String result = new Calculator().calculator("{{1,2},{1,2}} - 1");
        assertEquals("{{0.0,1.0},{0.0,1.0}}", result);
    }

    @Test
    public void matrixMulFloat() throws Exception {
        String result = new Calculator().calculator("{{1,2,1},{1,2,1},{1,2,1}} * 3");
        assertEquals("{{3.0,6.0,3.0},{3.0,6.0,3.0},{3.0,6.0,3.0}}", result);
    }

    @Test
    public void matrixDivFloat() throws Exception {
        String result = new Calculator().calculator("{{3,6,9},{3,6,9},{3,6,9}} / 3");
        assertEquals("{{1.0,2.0,3.0},{1.0,2.0,3.0},{1.0,2.0,3.0}}", result);
    }

    @Test
    public void matrixAddMatrix() throws Exception {
        String result = new Calculator().calculator("{{3,6,9},{3,6,9},{3,6,9}} + {{1,1,1},{1,1,1},{1,1,1}}");
        assertEquals("{{4.0,7.0,10.0},{4.0,7.0,10.0},{4.0,7.0,10.0}}", result);
    }

    @Test
    public void matrixSubMatrix() throws Exception {
        String result = new Calculator().calculator("{{3,6,9},{3,6,9},{3,6,9}} - {{1,1,1},{1,1,1},{1,1,1}}");
        assertEquals("{{2.0,5.0,8.0},{2.0,5.0,8.0},{2.0,5.0,8.0}}", result);
    }

    @Test
    public void matrixMulMatrix() throws Exception {
        String result = new Calculator().calculator("{{3,4,9},{3,1,9},{3,7,9}} * {{1,1,1},{1,1,1},{1,1,1}}");
        assertEquals("{{16.0,16.0,16.0},{13.0,13.0,13.0},{19.0,19.0,19.0}}", result);
    }

    @Test
    public void matrixMulVector() throws Exception {
        String result = new Calculator().calculator("{{3,4,9},{3,1,9},{3,7,9}} * {1,1,1}");
        assertEquals("{16.0,13.0,19.0}", result);
    }

}