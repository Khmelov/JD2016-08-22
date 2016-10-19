package by.it.snegurskiy.Mathlab;

import by.it.akhmelev.jd01_10.matlab_simple.Variable;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by snegurskiy.nn on 03.10.2016.
 */
public class VarTest {
    @Test
    public void add() throws Exception {
        Variable one=new Variable("2.2");
        Variable two=new Variable("3.0");
        Variable res=one.add(two);
        assertTrue(res.toString().equals("5.2"));
    }


}