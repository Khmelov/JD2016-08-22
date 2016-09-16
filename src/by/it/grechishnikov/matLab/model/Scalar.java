package by.it.grechishnikov.matLab.model;


public class Scalar extends Var {
    private double value;

    public Scalar(String name, double value) {
        super(name);
        this.value = value;
    }

    @Override
    public Var add(Scalar s) throws NotSupportedException {
        return new Scalar(name, this.value + s.getValue());
    }

    @Override
    public Var add(Vector var) throws NotSupportedException {
        return var.add(this);
    }

    @Override
    public Var add(Matrix var) throws NotSupportedException {
        return var.add(this);
    }

    @Override
    public Var sub(Scalar s) throws NotSupportedException {
        return new Scalar(name, this.value - s.getValue());
    }

    @Override
    public Var mul(Scalar s) throws NotSupportedException {
        return new Scalar(name, this.value * s.getValue());
    }

    @Override
    public Var div(Scalar s) throws NotSupportedException {
        return new Scalar(name, this.value / s.getValue());
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String valueToString() {
        return String.valueOf(value);
    }

    @Override
    public String toString() {
        return super.toString() +  valueToString();
    }
}
