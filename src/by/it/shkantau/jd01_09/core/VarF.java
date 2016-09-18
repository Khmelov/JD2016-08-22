package by.it.shkantau.jd01_09.core;

/**
 * Created by Aliaksei on 11.09.2016.
 */
public class VarF extends Var {

    public double value;
// Constructor
    public VarF(double v){
        this.value = v;
    }

    @Override
    public String toString() {
        return ((Double)value).toString();
    }

// Addition
    @Override
    public Var add(VarF d) {
        return new VarF(this.value + d.value);
    }
    @Override
    public Var add (VarV v){
        return v.add(this);
    }
    @Override
    public Var add (VarM m){
        return m.add(this);
    }

//   Subtraction
    @Override
    public Var sub(VarF d) {
    return new VarF(this.value - d.value);


//    @Override
//    public Var sub (VarV v){
//            return v.sub(this);
//    }
//    @Override
//        public Var sub (VarM m){
//            return m.add(this);
//        }
}

//   Multiplication
    @Override
    public Var mul(VarF d) {
        return new VarF(this.value * d.value);
    }
    @Override
    public Var mul (VarV v) {
        return v.mul(this);
    }
    @Override
    public  Var mul (VarM m){
        return m.mul(this);
    }
//  Division
    @Override
    public Var div (VarF s){
        return new VarF(value / s.value);
    }
    @Override
    public Var div (VarV v){
        return v.div(this);
    }

}
