package by.it.prymshyts.matlab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;

public class Parser implements RegexPatterns {

    static private HashMap<String, Variable> results = new HashMap<>();

    static Variable parse(String expression) {

        ArrayList<Variable> variables = new ArrayList<>();
        ArrayList<OperationType> operations = new ArrayList<>();
        String toSaveVar = null;

        expression = expression.replaceAll("\\s+", "");

        Matcher matcher = patternMainLoop.matcher(expression);

        int pos = 0;
        while(matcher.find(pos)) {
            pos = matcher.end();

            if (matcher.group(1) != null) {
                toSaveVar = matcher.group(1);
            } else if (matcher.group(2) != null) {
                if (results.containsKey(matcher.group(2))) {
                    variables.add(results.get(matcher.group(2)));
                } else {
                    variables.add(new FloatVariable(0.0));
                }
            } else if (matcher.group(3) != null) {
                variables.add(new FloatVariable(Double.parseDouble(matcher.group(3))));
            } else if (matcher.group(4) != null) {
                switch (matcher.group(4)) {
                    case "+":
                        operations.add(OperationType.ADD);
                        break;
                    case "-":
                        operations.add(OperationType.SUB);
                        break;
                    case "*":
                        operations.add(OperationType.MUL);
                        break;
                    case "/":
                        operations.add(OperationType.DIV);
                        break;
                }
            } else if (matcher.group(5) != null) {
                String bracketExpression = getBracketExpression(expression.substring(matcher.start()));
                variables.add(parseBrackets(bracketExpression));
                pos = matcher.start() + bracketExpression.length();
            }
        }

        Variable result = process(variables, operations);

        if (variables.size() > 1) {
            throw new IllegalOperationException(IllegalOperationExcetionState.INCORRECT_PARSING);
        }

        if (toSaveVar != null) {
            results.put(toSaveVar, result);
        }

        return result;
    }

    static private Variable process(ArrayList<Variable> variables, ArrayList<OperationType> operations) {

        while(operations.size() > 0) {
            int i = getOperationByPriority(operations);

            switch (operations.remove(i)) {
                case ADD:
                    variables.set(i, Calculator.add(variables.get(i), variables.remove(i + 1)));
                    break;
                case SUB:
                    variables.set(i, Calculator.sub(variables.get(i), variables.remove(i + 1)));
                    break;
                case MUL:
                    variables.set(i, Calculator.mul(variables.get(i), variables.remove(i + 1)));
                    break;
                case DIV:
                    variables.set(i, Calculator.div(variables.get(i), variables.remove(i + 1)));
                    break;
            }
        }

        return variables.get(0);
    }

    static private int getOperationByPriority(ArrayList<OperationType> operations) {
        for (int i = 0; i < operations.size(); i++) {
            if (operations.get(i) == OperationType.MUL || operations.get(i) == OperationType.DIV) {
                return i;
            }
        }
        return 0;
    }

    static private Variable parseBrackets(String expression) {
        Matcher matcher = patternMatrix.matcher(expression);

        if (matcher.find()) {
            return new MatrixVariable(parseMatrix(matcher.group(1)));
        }

        matcher = patternVector.matcher(expression);

        if (matcher.find()) {
            return new VectorVariable(parseVector(matcher.group(1)));
        }

        return parse(expression);
    }

    static private Double[] parseVector(String expression) {
        String[] vectorStr = expression.split(",");
        Double[] vector = new Double[vectorStr.length];

        for (int i = 0; i < vectorStr.length; i++) {
            vector[i] = Double.parseDouble(vectorStr[i]);
        }

        return vector;
    }

    static private Double[][] parseMatrix(String expression) {
        Matcher matcher = patternVector.matcher(expression);
        ArrayList<Double[]> matrix = new ArrayList<>();

        while(matcher.find()) {
            matrix.add(parseVector(matcher.group(1)));
        }

        Double[][] resultMatrix = new Double[matrix.size()][matrix.get(0).length];

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(0).length; j++) {
                resultMatrix[i][j] = matrix.get(i)[j];
            }
        }

        return resultMatrix;
    }

    static private String getBracketExpression(String expression) {
        int open = 0, close = 0, expressionLength = 0;

        do {
            char symb = expression.charAt(expressionLength++);

            if (symb == '(' || symb == '{') {
                open++;
            } else if (symb == ')' || symb == '}') {
                close++;
            }
        } while (open != close);

        return expression.substring(1, expressionLength);
    }
}