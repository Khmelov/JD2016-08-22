package by.it.aborisenok.matLab;

import java.util.Arrays;

/**
 * Created by Лёша on 09.09.2016.
 */
public class VarM extends Var {

    private double[][] value;

    public VarM(double[][] value){
        int rows=value.length;
        int cols=value[0].length;
        this.value=new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.value[i][j]=value[i][j];
            }
        }
    }

    public double[][] getValue() {
        return value;
    }

    public void setValue(double[][] value) {
        this.value = value;
    }

    @Override
    public Var add(VarF v) {
        VarM res=new VarM(value);
        int rows=value.length;
        int cols=value[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res.value[i][j]=res.value[i][j]+v.getValue();
            }
        }
        return res;
    }

    @Override
    public Var add(VarM v) {
        VarM res = new VarM(value);
        int rows=value.length;
        int cols=value[0].length;
        if (v.getValue().length == rows && v.getValue()[0].length == cols) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    res.value[i][j] = res.value[i][j] + v.getValue()[i][j];
                }
            }
            return res;
        } else {
            Log.print(" Разные размеры матриц");
            return null;
        }
    }

    @Override
    public String toString() {
        String res="[";
        String delimiter="";
        for (double[] v:value) {
            res=res+delimiter+Arrays.toString(v);
            delimiter=",";
        }
        res=res+"]";
        return res;
    }
}
