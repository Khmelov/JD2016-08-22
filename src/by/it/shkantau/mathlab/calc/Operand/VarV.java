package by.it.shkantau.mathlab.calc.Operand;

import by.it.shkantau.mathlab.calc.exceptions.MathLabException;
import by.it.shkantau.mathlab.util.Parser;

import java.util.Arrays;
import java.util.regex.Pattern;

public class VarV extends Var {

    private double [] vector;
    public static final String regexVarV ="\\{((-?([0-9.])+),?)+}";

    public VarV(double[] vector) {
        this.vector = new double[vector.length];
        System.arraycopy(vector,0,this.vector,0,vector.length);
    }

    public VarV (String str) throws MathLabException {
//  Check string for matches VarV expression
        if (Pattern.matches(regexVarV, str)) {
            vector = Parser.getDoublesArrayFromStr(str);
        } else {
            throw  new MathLabException("String \"" + str + "\" don't matches \"" + regexVarV + "\" pattern");
        }
    }

    @Override
    public String toString() {
        return "{"+Arrays.toString(vector).substring(1,Arrays.toString(vector).length()-1)+"}";
    }

    public double[] getVector() {
        return vector;
    }

    static VarV inverseVarV(VarV v){
        for (int i = 0; i < v.getVector().length; i++) {
            v.getVector()[i] *= -1;
        }
        return v;
    }

// Operations  //
    // Addition
    @Override
    public Var add (Var v){
        if (v instanceof VarF){
            VarV resVector = new VarV(new double[vector.length]);
            for (int i = 0; i < vector.length; i++) {
                resVector.vector[i] = this.vector[i] + ((VarF)v).getValue();
            }
            return resVector;
        }
        if (v instanceof VarV){
            VarV addVec = (VarV) v;
            if(vector.length ==  addVec.vector.length){
                VarV resVector = new VarV(new double[addVec.vector.length]);
                for (int i = 0; i < addVec.vector.length; i++) {
                    resVector.vector [i] = addVec.vector[i] + this.vector[i];
                }
                return resVector;
            }
        }
        return v.add(this);
    }

//    Subtraction
    @Override
    public Var sub(Var v) {
        VarV resVector;
        if (v instanceof VarF){
            resVector = new VarV(new double[vector.length]);
            for (int i = 0; i < vector.length; i++) {
                resVector.vector[i] = this.vector[i] - ((VarF)v).getValue();
            }
            return resVector;
        }
        if (v instanceof VarV){
            VarV vec = (VarV)v;
            if (vector.length == vec.vector.length) {
                resVector = new VarV(new double[vec.vector.length]);
                for (int i = 0; i < vec.vector.length; i++) {
                    resVector.vector[i] = this.vector[i]-vec.vector[i];
                }
                return resVector;
            }
        }
        return v.sub(v);
    }

//    Multiplication
    @Override
    public Var mul(Var v) {
        if(v instanceof VarF){
            VarV resVector = new VarV(new double[vector.length]);
            for (int i = 0; i < vector.length; i++) {
                resVector.vector[i] = this.vector[i] * ((VarF)v).getValue();
            }
            return resVector;
        }
        if(v instanceof VarV){
            if(vector.length == ((VarV)v).vector.length) {
                double resScalar = 0;
                for (int i = 0; i < vector.length; i++) {
                    resScalar += vector[i] * ((VarV)v).vector[i];
                }
                return new VarF(resScalar);
            }
        }

        return v.mul(v);
    }

//    Division
    @Override
    public Var div(Var v) {
        if(v instanceof VarF){
            return this.mul(new VarF(1/((VarF)v).getValue()));
        }
        return v.div(v);
    }
}
