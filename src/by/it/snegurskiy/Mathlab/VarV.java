package by.it.snegurskiy.Mathlab;

import java.util.Arrays;

/**
 * Created by user on 09.09.2016.
 */
public class VarV extends Var {
    public double [] value;
    public VarV(double [] value){
        this.value=new double[value.length];
        System.arraycopy(value,0,this.value,0,value.length);
    }

    @Override
    public Var add(VarF v) {
        VarV res=new VarV(value);
        for (int i = 0; i <res.value.length ; i++) {
            res.value[i]=res.value[i]+v.value;
        }
        return res;
    }

    @Override
    public String toString() {
        return Arrays.toString(value);
    }







}
