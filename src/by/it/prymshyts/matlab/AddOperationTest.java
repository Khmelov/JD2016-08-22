package by.it.prymshyts.matlab;

import org.junit.Test;

import static org.junit.Assert.*;

public class AddOperationTest {
    @Test
    public void FloatAddFloat() throws Exception {
        assertEquals(Parser.parse("1.0 + 1.0"), "2.0");
    }

    @Test
    public void FloatAddVector() throws Exception {
        assertEquals(Parser.parse("1.0 + {1.0, 2.0}"), "[2.0, 3.0]");
    }

    @Test
    public void FloatAddMatrix() throws Exception {
        assertEquals(Parser.parse("1.0 + {{1.0, 2.0} {3.0, 4.0}}"), "[[2.0, 3.0], [4.0, 5.0]]");
    }

    @Test
    public void VectorAddFloat() throws Exception {
        assertEquals(Parser.parse("{1.0, 2.0} + 1.0"), "[2.0, 3.0]");
    }

    @Test
    public void VectorAddVector() throws Exception {
        assertEquals(Parser.parse("{1.0, 2.0} + {1.0, 2.0}"), "[2.0, 4.0]");
    }

    @Test
    public void MatrixAddFloat() throws Exception {
        assertEquals(Parser.parse("{{1.0, 2.0} {3.0, 4.0}} + 1.0"), "[[2.0, 3.0], [4.0, 5.0]]");
    }

    @Test
    public void MatrixAddMatrix() throws Exception {
        assertEquals(Parser.parse("{{1.0, 2.0}{3.0, 4.0}} + {{1.0, 2.0}{3.0, 4.0}}"), "[[2.0, 4.0], [6.0, 8.0]]");
    }
}