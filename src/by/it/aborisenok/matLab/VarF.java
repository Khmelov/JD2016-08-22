package by.it.aborisenok.matLab;

/**
 * Created by Лёша on 09.09.2016.
 */
public class VarF extends Var{

    private double value;

    public VarF(double value){
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

//******************************************
    @Override
    public Var add(VarF v) {
        return new VarF(this.value + v.getValue());
    }

    @Override
    public Var add(VarV v) {
        return v.add(this);
    }

    @Override
    public Var add(VarM v) {

        return v.add(this);
    }
//******************************************
    @Override
    public Var sub(VarF v) {
        return new VarF(this.value - v.getValue());
    }

    @Override
    public Var sub(VarV v) {
        return v.sub(this);
    }

    public Var sub(VarM v){
        return v.sub(this);
    }
//******************************************

    @Override
    public Var mul(VarF v) {
        return new VarF(this.value * v.getValue());
    }

    @Override
    public Var mul(VarV v) {
        return v.mul(this);
    }

    @Override
    public Var mul(VarM v) {
        return v.mul(this);
    }
//******************************************

    @Override
    public Var div(VarF v) {
        return new VarF(this.value/v.getValue());
    }

    @Override
    public Var div(VarV v) {
        return v.div(this);
    }

    @Override
    public Var div(VarM v) {
        return v.div(this);
    }
//************************************************
    @Override
    public String toString() {
        return ((Double)value).toString();
    }
}
