package by.it.aborisenok.matLab.Tests;

import by.it.aborisenok.matLab.System.*;
import by.it.aborisenok.matLab.Vars.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by aborisenok on 05.10.2016.
 */
public class ParserTest {

    String a1 = "A=2+5.3";
    String a2 = "B=A*3.5";
    String a3 = "B1=B-0.55";
    String a4 = "B2=A/2";
    String b1 = "C=B+(A*2)";
    String b2 = "D=((C-0.15)-20)/(7-5)";
    String b3 = "{2,3}*(D/2)";
    String c1 = "{{2,2,2},{3,3,3},{4,4,4}}*(4/2)";
    String c2 = "{{2,2,2},{3,3,3},{4,4,4}}*{{2,2,2},{3,3,3},{4,4,4}}";
    String c3 = "{{2,2,2},{3,3,3},{4,4,4}}-{{1,1,1},{2,2,2},{2,2,2}}";
    String c4 = "{{2,2,2},{3,3,3},{4,4,4}}-6";
    String c5 = "(4+{{2,2,2},{3,3,3},{4,4,4}})*(3-1)";

    Parser parser = new Parser();

    @Test
    public void testCalcAdd() throws Exception {
        Var var = parser.doCalc(a1);
        assertEquals("7.3", var.toString());
    }

    @Test
    public void testCalcMul() throws Exception {
        Var var = parser.doCalc(a2);
        assertEquals("25.55", var.toString());
    }

    @Test
    public void testCalcSub() throws Exception {
        Var var = parser.doCalc(a3);
        assertEquals("25.0", var.toString());
    }

    @Test
    public void testCalcDiv() throws Exception {
        Var var = parser.doCalc(a4);
        assertEquals("3.65", var.toString());
    }

    @Test
    public void testCalcB1() throws Exception {
        Var var = parser.doCalc(b1);
        assertEquals("40.15", var.toString());
    }

    @Test
    public void testCalcB2() throws Exception {
        Var var = parser.doCalc(b2);
        assertEquals("10.0", var.toString());
    }

    @Test
    public void testCalcB3() throws Exception {
        Var var = parser.doCalc(b3);
        assertEquals("[10.0, 15.0]", var.toString());
    }

    @Test
    public void testCalcC1() throws Exception {
        Var var = parser.doCalc(c1);
        assertEquals("[[4.0, 4.0, 4.0],[6.0, 6.0, 6.0],[8.0, 8.0, 8.0]]", var.toString());
    }

    @Test
    public void testCalcC2() throws Exception {
        Var var = parser.doCalc(c2);
        assertEquals("[[18.0, 18.0, 18.0],[27.0, 27.0, 27.0],[36.0, 36.0, 36.0]]", var.toString());
    }

    @Test
    public void testCalcC3() throws Exception {
        Var var = parser.doCalc(c3);
        assertEquals("[[1.0, 1.0, 1.0],[1.0, 1.0, 1.0],[2.0, 2.0, 2.0]]", var.toString());
    }

    @Test
    public void testCalcC4() throws Exception {
        Var var = parser.doCalc(c4);
        assertEquals("[[-4.0, -4.0, -4.0],[-3.0, -3.0, -3.0],[-2.0, -2.0, -2.0]]", var.toString());
    }

    @Test
    public void testCalcC5() throws Exception {
        Var var = parser.doCalc(c5);
        assertEquals("[[12.0, 12.0, 12.0],[14.0, 14.0, 14.0],[16.0, 16.0, 16.0]]", var.toString());
    }
}