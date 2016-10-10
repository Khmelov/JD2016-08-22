package by.it.aborisenok.matLab.Vars;

import by.it.aborisenok.matLab.Errors.WrongSizeOfVariableEditions;
import by.it.aborisenok.matLab.Errors.WrongSizeOfVariableException;
import by.it.aborisenok.matLab.Interfaces.IVar;
import by.it.aborisenok.matLab.Log;
import by.it.aborisenok.matLab.System.Patterns;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Лёша on 09.09.2016.
 */
public class VarM extends Var implements IVar{


    public double[][] value;

    public VarM(String value) {
        setFrom(value);
    }

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


    public double[][] getValue() {
        return value;
    }
//******************************************
    @Override
    public Var add(VarF v) {
        VarM res = new VarM(value);
        int rows = value.length;
        int cols = value[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res.value[i][j ] += + v.getValue();
            }
        }
        return res;
    }

    public Var add(VarM v) {
        VarM res = new VarM(value);
        int rows=value.length;
        int cols=value[0].length;
        if (v.getValue().length == rows && v.getValue()[0].length == cols){
            for (int i = 0; i < rows; i++){
                for (int j = 0; j <cols; j++){
                    res.value[i][j] += v.getValue()[i][j];
                }
            }
            return res;
        } else {
            throw new WrongSizeOfVariableException(WrongSizeOfVariableEditions.ADD_MATRIX);
        }
    }
//******************************************
    @Override
    public Var sub(VarF v) {
        VarM res = new VarM(value);
        int rows = value.length;
        int cols = value[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res.value[i][j ] -= v.getValue();
            }
        }
        return res;
    }

    @Override
    public Var sub(VarM v) {
        VarM res = new VarM(value);
        int rows=value.length;
        int cols=value[0].length;
        if (v.getValue().length == rows && v.getValue()[0].length == cols){
            for (int i = 0; i < rows; i++){
                for (int j = 0; j <cols; j++){
                    res.value[i][j] -= v.getValue()[i][j];
                }
            }
            return res;
        } else {
            throw new WrongSizeOfVariableException(WrongSizeOfVariableEditions.SUB_MATRIX);
        }
    }
//******************************************
    @Override
    public Var mul(VarF v) {
        VarM res = new VarM(value);
        int rows = value.length;
        int cols = value[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res.value[i][j ] *= + v.getValue();
            }
        }
        return res;
    }

    @Override
    public Var mul(VarV v) {
        VarV res = new VarV(new double[value.length]);
        if (value.length == value[0].length &&
                value.length == v.getValue().length) {
            for (int i = 0; i < value.length; i++){
                for (int j = 0; j < v.getValue().length; j++)
                    res.getValue()[i] = res.getValue()[i] + value[i][j]*v.getValue()[j];
            }
            return res;
        } else {
            throw new WrongSizeOfVariableException(WrongSizeOfVariableEditions.MUL_VECTOR_AND_MATRIX);
        }
    }

    @Override
    public Var mul(VarM v) {
        VarM res = new VarM(new double[value.length][value[0].length]);
        int firstMatrixRows = value.length;
        int firstMatrixCols = value[0].length;
        int secondMatrixRows = v.getValue().length;
        int secondMatrixCols = v.getValue()[0].length;

        if (firstMatrixRows == secondMatrixRows && firstMatrixCols == secondMatrixRows
                && firstMatrixRows == firstMatrixCols) {
                for (int i = 0; i < value.length; i++) {
                    for (int j = 0; j < v.getValue()[0].length; j++) {
                        for (int k = 0; k < v.getValue().length; k++) {
                            res.getValue()[i][j] = res.getValue()[i][j] + value[i][k] * v.getValue()[k][j];
                        }
                    }
                }
            return res;
        } else {
            throw new WrongSizeOfVariableException(WrongSizeOfVariableEditions.MUL_MATRIX);
        }
    }
//***********************************

    @Override
    public Var div(VarF v) {
        VarM res = new VarM(value);
        int rows = value.length;
        int cols = value[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res.value[i][j ] /= + v.getValue();
            }
        }
        return res;
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
    public void setFrom(String str) {
       String s = str.replaceAll("\\[","\\{");
       String s1 = s.replaceAll("\\]","\\}");
       String[] strLine = s1.split("\\},\\{");
       int lines = strLine.length;
       String[] strCol = strLine[0].split(",");
       int columns = strCol.length;
       value = new double[lines][columns];

            for (int i = 0; i < lines; i++){
                int j = 0;
                Matcher m = Pattern.compile(Patterns.exVal).matcher(strLine[i]);
                while (m.find()) {
                    value[i][j]=Double.parseDouble(m.group());
                    j++;
                }
            }
    }
}
