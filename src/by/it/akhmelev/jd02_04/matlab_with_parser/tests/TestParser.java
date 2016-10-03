package by.it.akhmelev.jd02_04.matlab_with_parser.tests;

import by.it.akhmelev.jd02_04.matlab_with_parser.Parser;
import org.junit.Assert;

public class TestParser extends Assert{

    private boolean parse(String expression,String result) {
        return new Parser().calc(expression).toString().equals(result);
    }

    @org.junit.Test
    public void calcAdd() throws Exception {
        assertTrue("Не работает сложение", parse("2+2","4.0"));
    }
    @org.junit.Test
    public void calcSub() throws Exception {
        assertTrue("Не работает вычитание", parse("4-2","2.0"));
    }
    @org.junit.Test
    public void calcMul() throws Exception {
        assertTrue("Не работает умножение", parse("2*3","6.0"));
    }
    @org.junit.Test
    public void calcDiv() throws Exception {
        assertTrue("Не работает деление", parse("6/2","3.0"));
    }


    @org.junit.Test
    public void calcBigExpression() throws Exception {
        assertTrue("Не работает парсинг", parse("18+90/8+6*9+12-9","86.25"));
    }



}