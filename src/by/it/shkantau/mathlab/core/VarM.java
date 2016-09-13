package by.it.shkantau.mathlab.core;

import java.util.Arrays;

/**
 * Created by Aliaksei on 11.09.2016.
 */
public class VarM extends  Var{

    public double [][] matrix;
    private int rows;
    private int cols;

    public VarM(double[][] matrix) {
        rows=matrix.length;
        cols=matrix[0].length;
        this.matrix = new double[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.matrix[i][j]=matrix[i][j];
            }
        }
    }

    @Override
    public String toString() {
        String res="[";
        String delimiter="";
        for (double[] v : matrix) {
            res=res+delimiter+ Arrays.toString(v);
            delimiter=",";
        }
        res=res+"]";
        return res;
    }
// Addition
    @Override
    public Var add (VarF value){
        VarM resMatrix = new VarM(new double[rows][cols]);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resMatrix.matrix[i][j] = this.matrix[i][j] + value.value;
            }
        }
        return resMatrix;
    }
    @Override
    public Var add (VarM m){
        if (m.matrix.length == rows && m.matrix[0].length == cols){
            VarM resMatrix = new VarM(new double[rows][cols]);
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    resMatrix.matrix[i][j] = this.matrix[i][j] + m.matrix[i][j];
                }
            }
            return  resMatrix;
        }else {
            return null;
        }
    }
//    Subtraction
    @Override
    public Var sub (VarF value){
    VarM resMatrix = new VarM(new double[rows][cols]);
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            resMatrix.matrix[i][j] = this.matrix[i][j] - value.value;
        }
    }
    return resMatrix;
}
    @Override
    public Var sub (VarM m){
        if (m.matrix.length == rows && m.matrix[0].length == cols){
            VarM resMatrix = new VarM(new double[rows][cols]);
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    resMatrix.matrix[i][j] = this.matrix[i][j] - m.matrix[i][j];
                }
            }
            return  resMatrix;
        }else {
            return null;
        }
    }
//  Multiplication
    @Override
    public Var mul (VarF v){
        VarM resMatrix = new VarM(new double[rows][cols]);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resMatrix.matrix[i][j] = this.matrix[i][j] * v.value;
            }
        }
        return resMatrix;
    }
    /**
     *  Matrix and vector multiplication
     * @param v - multiplied vector
     * @return resVector - vector
     */
    @Override
    public Var mul (VarV v){
        if(v.vector.length == cols){
            VarV resVector = new VarV(new double[cols]);
            for (int i = 0; i < rows ; i++) {
                for (int j = 0; j < cols; j++) {
                    resVector.vector[i] += matrix[i][j] * v.vector[j];
                }
            }
            return resVector;
        }else {
            return null;
        }
    }
    /**
     * Matrix multiplication
     * @param  m - multiplied matrix
     * @return resMatrix - result of the matrix multiplication
     */
    @Override
    public Var mul  (VarM m){
        VarM resMatrix = new VarM(new double[rows][m.matrix[0].length]);
        for (int i = 0 ; i < rows ; i++) {
            for (int j = 0 ; j < m.matrix[0].length ; j++) {
                for (int k = 0 ; k < m.matrix.length ; k++) {
                    resMatrix.matrix[i][j] += matrix[i][k] * m.matrix[k][j];
                }
            }
        }
        return resMatrix;
    }
//    Division
    @Override
    public Var div (VarF s){
        return this.mul(new VarF(1/s.value));
    }







}
