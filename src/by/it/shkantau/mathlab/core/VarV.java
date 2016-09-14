package by.it.shkantau.mathlab.core;

import java.util.Arrays;

public class VarV extends Var {

    public double [] vector;

    public VarV(double[] vector) {
        this.vector = new double[vector.length];
        System.arraycopy(vector,0,this.vector,0,vector.length);
    }

    @Override
    public String toString() {
        return Arrays.toString(vector);
    }

    @Override
    public void setFrom(String str) {

    }

    // Addition
    @Override
    public Var add (VarF scalar){
        VarV resVector = new    VarV(new double[vector.length]);
        for (int i = 0; i < vector.length; i++) {
            resVector.vector[i] = this.vector[i] + scalar.value;
        }
        return resVector;
    }
    @Override
    public Var add (VarV v){
        if(vector.length ==  v.vector.length){
            VarV resVector = new VarV(new double[v.vector.length]);
            for (int i = 0; i < v.vector.length; i++) {
                resVector.vector [i] = v.vector[i] + this.vector[i];
            }
            return resVector;
        }else {
            return null;
        }
    }

//    Subtraction
    @Override
    public Var sub(VarF scalar) {
    VarV resVector = new VarV(new double[vector.length]);
    for (int i = 0; i < vector.length; i++) {
        resVector.vector[i] = this.vector[i] - scalar.value;
    }
    return resVector;}
    @Override
    public Var sub(VarV v) {
        if (vector.length == v.vector.length) {
            VarV resVector = new VarV(new double[v.vector.length]);
            for (int i = 0; i < v.vector.length; i++) {
                resVector.vector[i] = v.vector[i] - this.vector[i];
            }
            return resVector;
        } else {
            return null;
        }
    }

//    Multiplication
    @Override
    public Var mul (VarF scalar){
        VarV resVector = new VarV(new double[vector.length]);
        for (int i = 0; i < vector.length; i++) {
            resVector.vector[i] = this.vector[i] * scalar.value;
        }
        return resVector;
    }
    @Override
    public Var mul (VarV v){
        if(vector.length == v.vector.length){
            VarF resScalar = new VarF(0);
            for (int i = 0; i < vector.length; i++) {
                resScalar.value += vector[i] * v.vector[i];
            }
            return resScalar;
        }else {
            return null;
        }
    }
    @Override
    public Var mul (VarM m){
        return m.mul(this);
    }
//    Division
    @Override
    public Var div (VarF s){
        return this.mul(new VarF(1/s.value));
    }
}
