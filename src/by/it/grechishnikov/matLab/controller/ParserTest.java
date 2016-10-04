package by.it.grechishnikov.matLab.controller;

import by.it.grechishnikov.matLab.model.*;
import org.junit.Test;

import static org.junit.Assert.*;


public class ParserTest {
    @Test
    public void parseAdd() throws Exception {
        String text = "A=2+5.3";
        Var var = new Parser(new ReaderFromConsoleImplIReadable()).parse(text);
        assertEquals(var.toString(), "A = 7.3");
    }

    @Test
    public void parseMul() throws Exception {
        String text = "B=A*3.5";
        Var var = new Parser(new ReaderFromConsoleImplIReadable()).parse(text);
        assertEquals(var.toString(), "B = 25.55");
    }

    @Test
    public void parseSub() throws Exception {
        String text = "B1=B-0.55";
        Var var = new Parser(new ReaderFromConsoleImplIReadable()).parse(text);
        assertEquals(var.toString(), "B1 = 25.0");
    }

    @Test
    public void parseDiv() throws Exception {
        String text = "B2=A/2";
        Var var = new Parser(new ReaderFromConsoleImplIReadable()).parse(text);
        assertEquals(var.toString(), "B2 = 3.65");
    }
}