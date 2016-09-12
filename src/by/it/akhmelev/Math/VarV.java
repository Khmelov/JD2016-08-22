package by.it.akhmelev.Math;

import java.lang.reflect.Array;

public class VarV extends Var{
    private double[] value;
    public VarV(double[] m) {
        super(m);
        value=new double[m.length];
        System.arraycopy(m,0,value,0,m.length);
        Log.print(this.toString());
    }

    @Override
    public String toString() {
        String result="{";
        String delimiter="";
        for (Double d:value) {
            result = result + delimiter + d.toString();
            delimiter=", ";
        }
        return result+"}";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
