package by.it.grechishnikov.matLab.controller;

import org.junit.Test;
import static org.junit.Assert.*;


public class ParserTest {
    @Test
    public void parseScalarAdd() throws Exception {
        String text = "A=2+5.3";
        String test = new Parser().run(text);
        assertEquals(test, "A = 7.3");
    }

    @Test
    public void parseScalarMul() throws Exception {
        String text = "B=A*3.5";
        String test = new Parser().run(text);
        assertEquals(test, "B = 25.55");
    }

    @Test
    public void parseScalarSub() throws Exception {
        String text = "B1=B-0.55";
        String test = new Parser().run(text);
        assertEquals(test, "B1 = 25.0");
    }

    @Test
    public void parseScalarDiv() throws Exception {
        String text = "B2=A/2";
        String test = new Parser().run(text);
        assertEquals(test, "B2 = 3.65");
    }

    @Test
    public void test1() throws Exception {
        String text = "F=1-5.0*9.0";
        String test = new Parser().run(text);
        assertEquals(test, "F = -44.0");
    }

    @Test
    public void test2() throws Exception {
        String text = "F=20/2.0*100+200.0";
        String test = new Parser().run(text);
        assertEquals(test, "F = 1200.0");
    }

    @Test
    public void test3() throws Exception {
        String text = "F=3*3*3";
        String test = new Parser().run(text);
        assertEquals(test, "F = 27.0");
    }

    @Test
    public void parseVectorAddScalar() throws Exception {
        String text = "E={1,2,3}+3";
        String test = new Parser().run(text);
        assertEquals(test, "E = {4.0, 5.0, 6.0}");
    }

    @Test
    public void parseVectorSubScalar() throws Exception {
        String text = "E={3,4,5}-1";
        String test = new Parser().run(text);
        assertEquals(test, "E = {2.0, 3.0, 4.0}");
    }

    @Test
    public void parseVectorMulScalar() throws Exception {
        String text = "E={1,2,3}*2";
        String test = new Parser().run(text);
        assertEquals(test, "E = {2.0, 4.0, 6.0}");
    }

    @Test
    public void parseVectorDivScalar() throws Exception {
        String text = "E={9,6,3}/3";
        String test = new Parser().run(text);
        assertEquals(test, "E = {3.0, 2.0, 1.0}");
    }

    @Test
    public void parseVectorMulVector() throws Exception {
        String text = "a={1,2,3} * {4,5,6}";
        String test = new Parser().run(text);
        assertEquals(test, "a = {32.0}");
    }

    @Test
    public void parseVectorAddVector() throws Exception {
        String text = "a={1,2,3} + {4,5,6}";
        String test = new Parser().run(text);
        assertEquals(test, "a = {5.0, 7.0, 9.0}");
    }

    @Test
    public void parseVectorSubVector() throws Exception {
        String text = "a={4,5,6} - {4,5,6}";
        String test = new Parser().run(text);
        assertEquals(test, "a = {0.0, 0.0, 0.0}");
    }
}