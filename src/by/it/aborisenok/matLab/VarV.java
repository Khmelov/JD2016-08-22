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
//******************************************
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
                res.value[i] += v.getValue()[i];
            }
            return res;
        }
        else {
            Log.print("Разные размеры векторов");
            return null;
        }
    }
//******************************************
    @Override
    public Var sub(VarF v) {
        VarV res = new VarV(value);
        for (int i = 0; i < res.value.length; i++){
            res.value[i] -= v.getValue();
        }
        return res;
    }

    @Override
    public Var sub(VarV v) {
        VarV res = new VarV(value);
        if (res.value.length == v.getValue().length) {
            for (int i = 0; i < res.value.length; i++) {
                res.value[i] -= v.getValue()[i];
            }
            return res;
        } else {
            Log.print("Разные размеры векторов");
            return null;
        }
    }
//******************************************

    @Override
    public Var mul(VarF v) {
        VarV res = new VarV(value);
        for (int i = 0; i < res.value.length; i++){
            res.value[i] *= v.getValue();
        }
        return res;
    }

    @Override
    public Var mul(VarM v) {
        VarV res = new VarV(value);
        if (v.getValue().length == v.getValue()[0].length &&
                res.value.length == v.getValue().length) {
            for (int i = 0; i < res.value.length; i++) {
                for (int j = 0; j < v.getValue().length; j++) {
                    res.value[i] = res.value[i] + res.value[j] * v.getValue()[j][i];
                }
            }
            return res;
        } else {
            Log.print("Матрица должна быть квадратной и число её строк должно" +
                    "ровняться числу элементов вектора");
            return null;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(value);
    }
}
