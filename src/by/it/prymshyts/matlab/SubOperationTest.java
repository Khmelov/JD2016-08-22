package by.it.prymshyts.matlab;

import org.junit.Test;

import static org.junit.Assert.*;

public class SubOperationTest {
    @Test
    public void FloatSubFloat() throws Exception {
        assertEquals(Parser.parse("1.0 - 1.0"), "0.0");
    }

    @Test
    public void FloatSubVector() throws Exception {
        assertEquals(Parser.parse("1.0 - {1.0, 2.0}"), "[0.0, 1.0]");
    }

    @Test
    public void FloatSubMatrix() throws Exception {
        assertEquals(Parser.parse("1.0 - {{1.0, 2.0} {3.0, 4.0}}"), "[[0.0, 1.0], [2.0, 3.0]]");
    }

    @Test
    public void VectorSubFloat() throws Exception {
        assertEquals(Parser.parse("{1.0, 2.0} - 1.0"), "[2.0, 3.0]");
    }

    @Test
    public void VectorSubVector() throws Exception {
        assertEquals(Parser.parse("{1.0, 2.0} - {1.0, 2.0}"), "[0.0, 0.0]");
    }

    @Test
    public void MatrixSubFloat() throws Exception {
        assertEquals(Parser.parse("{{1.0, 2.0} {3.0, 4.0}} - 1.0"), "[[0.0, 1.0], [2.0, 3.0]]");
    }

    @Test
    public void MatrixSubMatrix() throws Exception {
        assertEquals(Parser.parse("{{1.0, 2.0}{3.0, 4.0}} - {{1.0, 2.0}{3.0, 4.0}}"), "[[0.0, 0.0], [0.0, 0.0]]");
    }

}