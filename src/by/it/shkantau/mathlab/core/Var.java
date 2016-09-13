package by.it.shkantau.mathlab.core;

/**
 * Created by Aliaksei on 10.09.2016.
 */
public abstract class Var implements IOperation, IVariable {

// Addition
    public Var add (Var v) {
        if (v instanceof VarF) return add((VarF) v);
        if (v instanceof VarV) return add((VarV) v);
        if (v instanceof VarM) return add((VarM) v);
        return null;
    }
    public Var add (VarF v){
        System.out.println("Addition with scalar is impossible!");
        return  null;
    }
    public Var add (VarV v){
        System.out.println("Addition with vector is impossible!");
        return  null;
    }
    public Var add (VarM v){
        System.out.println("Addition with matrix is impossible!");
        return  null;
    }
// Subtraction
    public Var sub (Var v){
        if (v instanceof VarF) return sub((VarF) v);
        if (v instanceof VarV) return sub((VarV) v);
        if (v instanceof VarM) return sub((VarM) v);
        return null;
    }
    public Var sub (VarF v){
        System.out.println("Subtraction with scalar is impossible!");
        return  null;
    }
    public Var sub (VarV v){
        System.out.println("Subtraction with vector is impossible!");
        return  null;
    }
    public Var sub (VarM v){
        System.out.println("Subtraction with matrix is impossible!");
        return  null;
    }
// Multiplication
    public Var mul (Var v){
        if (v instanceof VarF) return mul((VarF) v);
        if (v instanceof VarV) return mul((VarV) v);
        if (v instanceof VarM) return mul((VarM) v);
        return null;
    }
    public Var mul (VarF v){
        System.out.println("Multiplication with scalar is impossible!");
        return  null;
    }
    public Var mul (VarV v){
        System.out.println("Multiplication with vector is impossible!");
        return  null;
    }
    public Var mul (VarM v){
        System.out.println("Multiplication with matrix is impossible!");
        return  null;
    }
// Division
    public Var div (Var v){
        if (v instanceof VarF) return div((VarF) v);
        if (v instanceof VarV) return div((VarV) v);
        if (v instanceof VarM) return div((VarM) v);
        return null;
    }
    public Var div (VarF v){
        System.out.println("Division with scalar is impossible!");
        return  null;
    }
    public Var div (VarV v){
        System.out.println("Division with vector is impossible!");
        return  null;
    }
    public Var div (VarM v){
        System.out.println("Division with matrix is impossible!");
        return  null;
    }

}
