package by.it.prymshyts.matlab;

import org.junit.Test;

import static org.junit.Assert.*;

public class MulOperationTest {
    @Test
    public void FloatMulFloat() throws Exception {
        assertEquals(Parser.parse("2.0 * 2.0"), "4.0");
    }

    @Test
    public void FloatMulVector() throws Exception {
        assertEquals(Parser.parse("2.0 * {1.0, 2.0}"), "[2.0, 4.0]");
    }

    @Test
    public void FloatMulMatrix() throws Exception {
        assertEquals(Parser.parse("2.0 * {{1.0, 2.0} {3.0, 4.0}}"), "[[2.0, 4.0], [6.0, 8.0]]");
    }

    @Test
    public void VectorMulFloat() throws Exception {
        assertEquals(Parser.parse("{1.0, 2.0} * 2.0"), "[2.0, 4.0]");
    }

    @Test
    public void MatrixMulFloat() throws Exception {
        assertEquals(Parser.parse("{{1.0, 2.0} {3.0, 4.0}} * 2.0"), "[[2.0, 4.0], [6.0, 8.0]]");
    }

    @Test
    public void MatrixMulVector() throws Exception {
        assertEquals(Parser.parse("{{1.0, 2.0} {3.0, 4.0}} * {2.0, 3.0}"), "[8.0, 18.0]");
    }

    @Test
    public void MatrixMulMatrix() throws Exception {
        assertEquals(Parser.parse("{{1.0, 2.0}{3.0, 4.0}} * {{1.0, 2.0}{3.0, 4.0}}"), "[[7.0, 10.0], [15.0, 22.0]]");
    }
}