package by.it.voronovich.MathLab.Operation;

import by.it.voronovich.MathLab.Var.Variable;

import java.util.HashMap;

public class KeyMapper {


        public static HashMap<String, Variable> variable = new HashMap<>();

        private KeyMapper() {
        }

        /**
         * Присваивает значение переменной
         * @param key переменная
         * @param var значение
         */
        public static void setParameter(String key, Variable var) {
            variable.put(key, var);
        }

        public static HashMap<String, Variable> getVariables() {
            return variable;
        }

        public static void printVar() {
            for (HashMap.Entry<String, Variable> pair: variable.entrySet()) {
                System.out.printf("%4s = %3.2s", pair.getKey(), pair.getValue());
                System.out.println(" ");
            }
        }
    }
