package by.it.aborisenok.matLab;

import java.util.Arrays;

/**
 * Created by Лёша on 09.09.2016.
 */
public class VarM extends Var {

    private double[][] value;

    public VarM(double[][] value){
        int rows = value[0].length;
        int cols = value.length;
        this.value = new double[cols][rows];
        for (int i = 0; i < cols; i++){
            for (int j = 0; i < rows; j++){
                this.value[i][j] = value[i][j];
            }
        }
    }

    @Override
    public Var add(VarF v) {
        VarM res = new VarM(value);

        int rows = value[0].length;
        int cols = value.length;
        this.value = new double[cols][rows];
        for (int i = 0; i < cols; i++){
            for (int j = 0; i < rows; j++){
                res.value[i][j] = res.value[i][j] + v.getValue();
            }
        }
        return res;
    }

    @Override
    public String toString() {



        return "VarM{" +
                "value=" + Arrays.toString(value) +
                '}';
    }
}
