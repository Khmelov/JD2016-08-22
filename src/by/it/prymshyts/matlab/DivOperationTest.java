package by.it.prymshyts.matlab;

import org.junit.Test;

import static org.junit.Assert.*;

public class DivOperationTest {
    @Test
    public void FloatDivFloat() throws Exception {
        assertEquals(Parser.parse("4.0 / 2.0").toString(), "2.0");
    }

    @Test
    public void VectorDivFloat() throws Exception {
        assertEquals(Parser.parse("{2.0, 4.0} / 2.0").toString(), "[1.0, 2.0]");
    }

    @Test
    public void MatrixDivFloat() throws Exception {
        assertEquals(Parser.parse("{{2.0, 4.0}{2.0, 4.0}} / 2.0").toString(), "[[1.0, 2.0], [1.0, 2.0]]");
    }
}