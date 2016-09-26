package by.it.filimonchik.MatLab;

/**
 * Created by Raman.Filimonchyk on 22/09/2016.
 */
public class Variable implements IMatLab {
    private Double value;
    public Variable (){
    }
    public Variable(String string){
        this.value=Double.valueOf(String.valueOf(string));
    }

    public Variable(Double value) {
        this.value = value;
    }

    @Override
    public Variable add(Variable varAdd) {
        Variable out = new Variable();
        out.value=this.value+varAdd.value;
        return out;
    }

    @Override
    public Variable sub(Variable varSub) {
        Variable out = new Variable();
        out.value=this.value-varSub.value;
        return out;
    }

    @Override
    public Variable mul(Variable varMul) {
        Variable out = new Variable();
        out.value=this.value*varMul.value;
        return out;
    }

    @Override
    public Variable div(Variable varDiv) {
        Variable out = new Variable();
        out.value=this.value/varDiv.value;
        return out;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
