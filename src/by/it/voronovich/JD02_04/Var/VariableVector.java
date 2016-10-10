package by.it.voronovich.JD02_04.Var;

import by.it.voronovich.JD02_04.Operation.KeyMapper;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.it.voronovich.JD02_04.Parser.exFloat;

/**
 * @author Voronovich Dmitry
 * @version 1.1
 */
public class VariableVector extends Variable {

    private double[] valueVector;

    public VariableVector(double[] valueVector) {
        this.valueVector = new double[valueVector.length];
        this.valueVector = valueVector.clone();
    }

    public VariableVector(int length) {
        this.valueVector = new double[length];
    }

    public VariableVector(String valueVector) {
        setValue(valueVector);
    }

    @Override
    public double[] getValue() {
        return this.valueVector;
    }

    public void setValue(double[] valueVector) {
        this.valueVector = new double[valueVector.length];
        this.valueVector = valueVector.clone();
    }

    @Override
    public boolean saveVar(String name) {
        Map<String, Variable> nameVariables = KeyMapper.getVariable();
        nameVariables.put(name, new VariableVector(this.valueVector));
        return true;
    }

    @Override
    public double[] readVar(String name) {
        Map<String, Variable> nameVariables = KeyMapper.getVariable();
        if (nameVariables.containsKey(name)) {
            return ((VariableVector) nameVariables.get(name)).getValue();
        }
        return null;
    }

    @Override
    public void setValue(String value) {
        String[] elem = value.split(",");
        valueVector = new double[elem.length];
        Matcher mat = Pattern.compile(exFloat).matcher(value);
        int i = 0;
        while (mat.find()) {
            valueVector[i] = Double.parseDouble(mat.group());
            i++;
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("{");
        int k = 0;
        for (Double v : valueVector) {
            k++;
            s = s.append(v.toString());
            if (k != valueVector.length) {
                s.append(",");
            } else {
                s.append("}");
            }
        }
        return s.toString();
    }
}