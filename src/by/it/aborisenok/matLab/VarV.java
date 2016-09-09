package by.it.aborisenok.matLab;

import java.util.Arrays;

/**
 * Created by Лёша on 09.09.2016.
 */
public class VarV extends Var {

    private double[] value;

    public VarV(double[] value){
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0,value.length);
    }

    public double[] getValue() {
        return value;
    }

    public void setValue(double[] value) {
        this.value = new double[value.length];
    }

    @Override
    public Var add(VarF v) {
        VarV res = new VarV(value);
        for (int i = 0; i < res.value.length; i++){
            res.value[i] = res.value[i] + v.getValue();
        }
        return res;
    }

    @Override
    public Var add(VarV v) {
        VarV res = new VarV(value);
        if (res.value.length == v.getValue().length){
            for (int i = 0; i < res.value.length; i++){
                res.value[i] = res.value[i] + v.getValue()[i];
            }
            return res;
        }
        else {
            Log.print("Разные размеры векторов");
            return null;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(value);
    }
}
