package by.it.grechishnikov.matLab.model;


public class Scalar extends Var {
    private double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(String name, double value) {
        super(name);
        this.value = value;
        if(value > Double.MAX_VALUE && value < Double.MIN_VALUE) {
            System.out.println("Операция невозможна");
            this.alive = false;
        }
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
        return super.toString() +  valueToString() + "\n";
    }
}
