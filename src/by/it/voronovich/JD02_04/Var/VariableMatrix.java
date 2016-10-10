package by.it.voronovich.JD02_04.Var;

import by.it.voronovich.JD02_04.Operation.KeyMapper;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.it.voronovich.JD02_04.Parser.*;

/**
 * @author Voronovich Dmitry
 * @version 1.1
 */
public class VariableMatrix extends Variable {

    private double[][] valueMatrix;

    public VariableMatrix(double [][] valueMatrix) {
        this.valueMatrix = new double [valueMatrix.length] [valueMatrix.length];
        this.valueMatrix = valueMatrix.clone();
    }

    public VariableMatrix(int length) {
        this.valueMatrix = new double [length] [length];
    }

    public VariableMatrix(String valueMatrix) {
        setValue (valueMatrix);
    }

    @Override
    public double[][] getValue() {
        return this.valueMatrix;
    }

    public void setValue(double[][] valueMatrix) {
        this.valueMatrix = new double [valueMatrix.length][valueMatrix.length];
        this.valueMatrix = valueMatrix.clone();
    }

    @Override
    public boolean saveVar(String name) {
        Map<String, Variable> nameVariables = KeyMapper.getVariable();
        nameVariables.put(name, new VariableMatrix(this.valueMatrix));
        return true;
    }

    @Override
    public double[][] readVar(String name) {
        Map <String, Variable> nameVariables = KeyMapper.getVariable();
        if (nameVariables.containsKey(name)) {
            return ((VariableMatrix) nameVariables.get(name)).getValue();
        }
        return null;
    }

    @Override
    public void setValue (String value) {
        String[] elem=value.split("[\\}\\]],[\\{\\[]");
        valueMatrix=new double[elem.length][elem.length];
        for (int i=0; i<elem.length; i++) {
            Matcher mat = Pattern.compile(exFloat).matcher(elem[i]);
            int j = 0;
            while (mat.find()) {
                valueMatrix[i][j] = Double.parseDouble(mat.group());
                j++;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("{{");
        int k = 0;
        for (double[] v : valueMatrix) {
            for (Double m : v) {
                k++;
                s = s.append(m.toString());
                if (k % valueMatrix.length != 0) {
                    s.append(",");
                } else if (k != valueMatrix.length * valueMatrix.length) {
                    s.append("},{");
                } else {
                    s.append("}}");
                }
            }
        }
        return s.toString();
    }
}