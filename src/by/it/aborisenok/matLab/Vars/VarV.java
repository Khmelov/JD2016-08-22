package by.it.aborisenok.matLab.Vars;

import by.it.aborisenok.matLab.Errors.*;
import by.it.aborisenok.matLab.Interfaces.IVar;
import by.it.aborisenok.matLab.Log;
import by.it.aborisenok.matLab.System.Patterns;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Лёша on 09.09.2016.
 */
public class VarV extends Var implements IVar{

    private double[] value;

    public VarV(String value){
        setFrom(value);
    }

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
            throw new WrongSizeOfVariableException(WrongSizeOfVariableEditions.ADD_VECTORS);
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
            throw new WrongSizeOfVariableException(WrongSizeOfVariableEditions.SUB_VECTORS);
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
    public Var mul(VarV v) {
        double res = 0;
        if (value.length == v.getValue().length ) {
            for (int i = 0; i < value.length; i++){
                res = res + value[i] * v.getValue()[i];
            }
            return new VarF(res);
        } else {
            throw new WrongSizeOfVariableException(WrongSizeOfVariableEditions.MUL_VECTOR);
        }
    }

    @Override
    public Var mul(VarM v) {
        VarV res = new VarV(new double[value.length]);
        if (v.getValue().length == v.getValue()[0].length &&
                res.getValue().length == v.getValue().length) {
            for (int i = 0; i < res.value.length; i++) {
                for (int j = 0; j < v.getValue().length; j++) {
                    res.value[i] = res.value[i] + value[j] * v.getValue()[j][i];
                }
            }
            return res;
        } else {
            throw new WrongSizeOfVariableException(WrongSizeOfVariableEditions.MUL_MATRIX);
        }
    }
//*******************************************************

    @Override
    public Var div(VarF v) {
        VarV res = new VarV(value);
        for (int i = 0; i < res.value.length; i++){
            res.value[i] /= v.getValue();
        }
        return res;
    }

//*******************************************************
    @Override
    public String toString() {
        return Arrays.toString(value);
    }

    @Override
    public void setFrom(String str) {
        String[] elem = str.split(",");
        value = new double[elem.length];
        Matcher m = Pattern.compile(Patterns.exVal).matcher(str);
        int i=0;
        while (m.find()) {
            value[i]=Double.parseDouble(m.group());
            i++;
        }
    }
}
