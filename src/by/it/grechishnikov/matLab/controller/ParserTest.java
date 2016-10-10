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
    public void test4() throws Exception {
        String text = "a = 1 - ((1 + 1) * 2)";
        String test = new Parser().run(text);
        assertEquals(test, "a = -3.0");
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
    public void parseMatrixAddScalar() throws Exception {
        String text = "a={{1.0,2.0,3.0},{4.0,5.0,6.0}}+10";
        String test = new Parser().run(text);
        assertEquals(test, "a = {{11.0,12.0,13.0},{14.0,15.0,16.0}}");
    }

    @Test
    public void parseMatrixSubScalar() throws Exception {
        String text = "a={{1,2,3},{4,5,6}} -3";
        String test = new Parser().run(text);
        assertEquals(test, "a = {{-2.0,-1.0,0.0},{1.0,2.0,3.0}}");
    }

    @Test
    public void parseMatrixMulScalar() throws Exception {
        String text = "a={{1,2,3},{4,5,6}}*3";
        String test = new Parser().run(text);
        assertEquals(test, "a = {{3.0,6.0,9.0},{12.0,15.0,18.0}}");
    }

    @Test
    public void parseMatrixDivScalar() throws Exception {
        String text = "a={{1,2,3},{4,5,6}}/2";
        String test = new Parser().run(text);
        assertEquals(test, "a = {{0.5,1.0,1.5},{2.0,2.5,3.0}}");
    }

    @Test
    public void parseMatrixAddVector() throws Exception {
        String text = "a={{1,2,3},{4,5,6}} + {1,2}";
        String test = new Parser().run(text);
        assertEquals(test, "a = {{2.0,3.0,4.0},{6.0,7.0,8.0}}");
    }

    @Test
    public void parseMatrixSubVector() throws Exception {
        String text = "a={{1,2,3},{4,5,6}} - {1,2}";
        String test = new Parser().run(text);
        assertEquals(test, "a = {{0.0,1.0,2.0},{2.0,3.0,4.0}}");
    }

    @Test
    public void parseMatrixAddMatrix() throws Exception {
        String text = "a={{1,2,3},{4,5,6}} + {{1,2,3},{4,5,6}";
        String test = new Parser().run(text);
        assertEquals(test, "a = {{2.0,4.0,6.0},{8.0,10.0,12.0}}");
    }

    @Test
    public void parseMatrixSubMatrix() throws Exception {
        String text = "a={{1,2,3},{4,5,6}} - {{1,2,3},{4,5,6}";
        String test = new Parser().run(text);
        assertEquals(test, "a = {{0.0,0.0,0.0},{0.0,0.0,0.0}}");
    }

    @Test
    public void parseMatrixMulMatrix() throws Exception {
        String text = "a={{1,2,3},{4,5,6},{7,8,9}} * {{1,2,3},{4,5,6},{7,8,9}}";
        String test = new Parser().run(text);
        assertEquals(test, "a = {{30.0,36.0,42.0},{66.0,81.0,96.0},{102.0,126.0,150.0}}");
    }
}