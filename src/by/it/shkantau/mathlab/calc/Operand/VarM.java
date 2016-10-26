package by.it.shkantau.mathlab.calc.Operand;

import by.it.shkantau.mathlab.calc.exceptions.MathLabException;
import by.it.shkantau.mathlab.util.Parser;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class VarM extends Var {

    private double [][] matrix;
    private int rows;
    private int cols;
    public static final String regexVarM  = "\\{((\\{((-?([0-9.])+),?)+}),?)+}";

    public VarM(double[][] matrix) {
        rows=matrix.length;
        cols=matrix[0].length;
        this.matrix = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(matrix[i], 0, this.matrix[i], 0, cols);
        }
    }

    public VarM(String str) throws MathLabException {
//  Check string for matches VarM expression
        if (Pattern.matches(regexVarM, str)) {
            List<String> listOfStringRow = Parser.parseToVarString(str, Pattern.compile(VarV.regexVarV));
            List<String> listOfStringVarF = Parser.parseToVarString(listOfStringRow.get(0), Pattern.compile(VarF.regexVarF));
            double[][] doubles = new double[listOfStringRow.size()][listOfStringVarF.size()];
            for (int i = 0; i < listOfStringRow.size() ; i++) {
                listOfStringVarF = Parser.parseToVarString(listOfStringRow.get(i), Pattern.compile(VarF.regexVarF));
                for (int j = 0; j < listOfStringVarF.size(); j++) {
                    doubles [i][j] = Double.parseDouble(listOfStringVarF.get(j));
                }
            }
            this.matrix = doubles;
            rows = matrix.length;
            cols = matrix[0].length;
        } else {
            throw  new MathLabException("String \"" + str + "\" don't matches \"" + regexVarM + "\" pattern");
        }
    }

    public double[][] getMatrix() {
        return matrix;
    }

    static VarM inverseVarM(VarM m){
        int rows = m.matrix.length;
        int cols = m.matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                m.matrix[i][j] *= -1;
            }
        }
        return m;
    }

    @Override
    public String toString() {
        String res="{";
        String delimiter="";
        String line;
        for (double[] v : matrix) {
            line = "{"+Arrays.toString(v).substring(1,Arrays.toString(v).length()-1)+"}";

            res=res+delimiter+line ;//Arrays.toString(v);
            delimiter=",";
        }
        res=res+"}";
        return res;
    }

    //  Addition
    @Override
    public Var add(Var v) {
        if(v instanceof VarF){
            VarM resMatrix = new VarM(new double[rows][cols]);
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    resMatrix.matrix[i][j] = this.matrix[i][j] + ((VarF)v).getValue();
                }
            }
            return resMatrix;
        }
        if(v instanceof VarM){
            VarM m = (VarM)v;
            if (m.matrix.length == rows && m.matrix[0].length == cols){
                VarM resMatrix = new VarM(new double[rows][cols]);
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        resMatrix.matrix[i][j] = this.matrix[i][j] + m.matrix[i][j];
                    }
                }
                return  resMatrix;
            }
        }
        return v.add(v);
    }

//  Subtraction
    @Override
    public Var sub(Var v) {
        VarM resVarM = new VarM(new double[rows][cols]);
        if(v instanceof VarF){
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    resVarM.matrix[i][j] = this.matrix[i][j] - ((VarF)v).getValue();
                }
            }
        }
        if(v instanceof VarM){
            VarM m = (VarM)v;
            if (m.matrix.length == rows && m.matrix[0].length == cols) {
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        resVarM.matrix[i][j] = this.matrix[i][j] - m.matrix[i][j];
                    }
                }
                return resVarM;
            }
        }
        if (resVarM != null){ ///////!!!!!!!!!! Warning:(122, 13) Condition 'resVarM != null' is always 'true'
            return resVarM;
        }
        return v.sub(v);
    }

//  Multiplication
    @Override
    public Var mul(Var v) {
        VarM resMatrix = null;
        if(v instanceof VarF){
            resMatrix = new VarM(new double[rows][cols]);
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    resMatrix.matrix[i][j] = this.matrix[i][j] * ((VarF)v).getValue();
                }
            }
        }
        if (v instanceof VarV){
            VarV vec = (VarV) v;
            if(vec.getVector().length == cols) {
                VarV resVector = new VarV(new double[cols]);
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        resVector.getVector()[i] += matrix[i][j] * vec.getVector()[j];
                    }
                }
                return resVector;
            }
        }
//        {{2.2, 5.8},{1.5, 6.2},{-2.5,7.4},{4.2,-2.3}} * {{5.2,3.2,3.8},{6.8,-7.5,-1.9}}
        if(v instanceof VarM){
            VarM m = (VarM)v;
            if(this.cols == m.matrix.length){
                resMatrix = new VarM(new double[this.rows][m.getMatrix()[0].length]);
                // matrix * m.matrix
                for (int i = 0 ; i < rows ; i++) {
                    for (int j = 0 ; j < m.matrix[0].length ; j++) {
                        for (int k = 0 ; k < cols ; k++) {
                            resMatrix.matrix[i][j] += matrix[i][k] * m.matrix[k][j];
                        }
                    }
                }

            }
        }

        if(resMatrix != null){
            return resMatrix;
        }

        return v.mul(v);
    }

//    Division
    @Override
    public Var div(Var v) {
        if(v instanceof  VarF){
            return this.mul(new VarF(1/((VarF)v).getValue()));
        }
        return v.div(v);
    }

}
