package by.it.voronovich.JD02_04.Var;

import by.it.voronovich.JD02_04.Operation.KeyMapper;

import java.util.Map;

/**
 * @author Voronovich Dmitry
 * @version 1.1
 */
public class VariableFloat extends Variable {

    private double valueFloat;

    public VariableFloat() {
        this.valueFloat = 0;
    }

    public VariableFloat(double valueD) {
        this.valueFloat = valueD;
    }

    public VariableFloat(String valueD) {
        setValue(valueD);
    }

    @Override
    public Double getValue() {
        return this.valueFloat;
    }

    public void setValue(Double valueFloat) {
        this.valueFloat = valueFloat;
    }

    @Override
    public boolean saveVar(String name) {
        Map<String, Variable> nameVariables = KeyMapper.getVariable();
        nameVariables.put(name, new VariableFloat(this.valueFloat));
        return true;
    }

    @Override
    public Double readVar(String name) {
        Map<String, Variable> nameVariables = KeyMapper.getVariable();
        if (nameVariables.containsKey(name)) {
            return ((VariableFloat) nameVariables.get(name)).getValue();
        }
        return null;
    }

    @Override
    public void setValue(String value) {
        this.valueFloat = Double.valueOf(value);
    }

    @Override
    public String toString() {
        return ((Double) valueFloat).toString();
    }
}