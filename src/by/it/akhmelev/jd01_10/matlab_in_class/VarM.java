package by.it.akhmelev.jd01_10.matlab_in_class;

import java.util.Arrays;

public class VarM extends Var {
    public double[][] value;
    public VarM(double[][] value) {
        int rows=value.length;
        int cols=value[0].length;
        this.value=new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.value[i][j]=value[i][j];
            }
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

    @Override
    public Var add(VarF v) {
        VarM res=new VarM(value);
        int rows=value.length;
        int cols=value[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res.value[i][j]=res.value[i][j]+v.value;
            }
        }
        return res;
    }


}
