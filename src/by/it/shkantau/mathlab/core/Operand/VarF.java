package by.it.shkantau.mathlab.core.Operand;

/**
 * Created by Aliaksei on 11.09.2016.
 */
public class VarF extends Var {

    private double value;
    public static final String regexVarF = "((-?)([0-9.])+)";

// Constructors
    public VarF(double v){

        this.value = v;
    }

    public VarF(String str){
        try {this.value = Double.parseDouble(str);
        }catch (NumberFormatException e){
            new Error("NumberFormatException, can't convert str to Double");
        }
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return ((Double)this.value).toString();
    }

//  Addition
    @Override
    public Var add(Var v) {
        if (v instanceof VarF) {
            return new VarF(this.value + ((VarF) v).value);
        }
        if (v instanceof VarV) {
            return v.add(this);
        }
        if (v instanceof VarM) {
            return v.add(this);
        }
        return v.add(this);
    }

//   Subtraction
    @Override
    public Var sub(Var v) {
        if (v instanceof VarF){
            return new VarF(this.getValue() - ((VarF) v).getValue());
        }
        if( v instanceof VarV){
            return  VarV.inverseVarV((VarV)v).add(this);
        }
        if(v instanceof  VarM){
            return VarM.inverseVarM((VarM)v).add(this);
        }
        return v.sub(v);
    }

//   Multiplication
    @Override
    public Var mul(Var v) {
        if(v instanceof  VarF){
            return new VarF(this.getValue() * ((VarF)v).getValue());
        }
        if (v instanceof VarV){
            return v.mul(this);
        }
        if (v instanceof VarM){
            v.mul(this);
        }
        return v.mul(v);
    }

//  Division
    @Override
    public Var div(Var v) {
        if(v instanceof  VarF){
            return new VarF(this.getValue() / ((VarF)v).getValue());
        }
        return v.div(v);
    }
}
