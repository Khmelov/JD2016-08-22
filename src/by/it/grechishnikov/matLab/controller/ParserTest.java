package by.it.grechishnikov.matLab.controller;

import org.junit.Test;
import static org.junit.Assert.*;


public class ParserTest {
    @Test
    public void parseAdd() throws Exception {
        String text = "A=2+5.3";
        String test = new Parser().run(text);
        assertEquals(test, "A = 7.3");
    }

    @Test
    public void parseMul() throws Exception {
        String text = "B=A*3.5";
        String test = new Parser().run(text);
        assertEquals(test, "B = 25.55");
    }

    @Test
    public void parseSub() throws Exception {
        String text = "B1=B-0.55";
        String test = new Parser().run(text);
        assertEquals(test, "B1 = 25.0");
    }

    @Test
    public void parseDiv() throws Exception {
        String text = "B2=A/2";
        String test = new Parser().run(text);
        assertEquals(test, "B2 = 3.65");
    }

    @Test
    public void parseVector() throws Exception {
        String text = "E={2,3}*(D/2)";
        String test = new Parser().run(text);
        assertEquals(test, "F = 27.0");
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
}