package by.it.voronovich.MathLab;

import by.it.voronovich.MathLab.Operation.Operation;
import by.it.voronovich.MathLab.Var.VariableMatrix;
import by.it.voronovich.MathLab.Var.VariableFloat;
import by.it.voronovich.MathLab.Var.VariableVector;

public class Main {

    public static void main(String[] args) {

        VariableFloat f1 = new VariableFloat(5.0);
        VariableFloat f2 = new VariableFloat(10.0);

        double[] v1 = {1, 2, 3};
        VariableVector vct1 = new VariableVector(v1);
        double[] v2 = {1, 2, 3, 1, 2};
        VariableVector vct2 = new VariableVector(v2);

        double[][] Matrix1 = {{1, 2, 3},
                {1, 1, 1},
                {1, 1, 1}};
        double[][] Matrix2 = {{1, 2, 3, 1, 2},
                {3, 1, 2, 3, 1},
                {2, 3, 1, 2, 3},
                {1, 1, 1, 1, 1}};
        VariableMatrix m1 = new VariableMatrix(Matrix1);
        VariableMatrix m2 = new VariableMatrix(Matrix2);

        System.out.println("------------------>>>>>Проверка операций сложения<<<<<------------------");
        System.out.println("скаляр+скаляр:");
        System.out.println(Operation.add(f1, f2));
        System.out.println("скаляр+вектор:");
        System.out.println(Operation.add(f2, vct1));
        System.out.println("скаляр+матрица:");
        System.out.println(Operation.add(f2, m1));
        System.out.println("------------------------------------------------------------------------");
        System.out.println("вектор+скаляр:");
        System.out.println(Operation.add(vct1, f1));
        System.out.println("вектор+вектор:");
        System.out.println(Operation.add(vct1, vct2));
        System.out.println("вектор+вектор:");
        System.out.println(Operation.add(vct1, vct1));
        System.out.println("вектор+матрица:");
        System.out.println(Operation.add(vct1, m1));
        System.out.println("вектор+матрица:");
        System.out.println(Operation.add(vct1, m2));
        System.out.println("------------------------------------------------------------------------");
        System.out.println("матрица+скаляр:");
        System.out.println(Operation.add(m1, f1));
        System.out.println("матрица+вектор:");
        System.out.println(Operation.add(m1, vct1));
        System.out.println("матрица+вектор:");
        System.out.println(Operation.add(m2, vct1));
        System.out.println("матрица+матрица:");
        System.out.println(Operation.add(m1, m1));
        System.out.println("матрица+матрица:");
        System.out.println(Operation.add(m1, m2));
        System.out.println("/////////////////////////////////////////////////////////////////////////");

        System.out.println("------------------>>>>>Проверка операций вычетания<<<<<------------------");
        System.out.println("скаляр-скаляр:");
        System.out.println(Operation.sub(f1, f2));
        System.out.println("скаляр-вектор:");
        System.out.println(Operation.sub(f2, vct1));
        System.out.println("скаляр-матрица:");
        System.out.println(Operation.sub(f2, m1));
        System.out.println("------------------------------------------------------------------------");
        System.out.println("вектор-скаляр:");
        System.out.println(Operation.sub(vct2, f2));
        System.out.println("вектор-вектор:");
        System.out.println(Operation.sub(vct2, vct1));
        System.out.println("вектор-матрица:");
        System.out.println(Operation.sub(vct2, m1));
        System.out.println("------------------------------------------------------------------------");
        System.out.println("матрица-скаляр:");
        System.out.println(Operation.sub(m2, f2));
        System.out.println("матрица-вектор:");
        System.out.println(Operation.sub(m2, vct1));
        System.out.println("матрица-матрица:");
        System.out.println(Operation.sub(m2, m1));
        System.out.println("/////////////////////////////////////////////////////////////////////////");

        System.out.println("------------------>>>>>Проверка операций умножения<<<<<------------------");
        System.out.println("скаляр*скаляр:");
        System.out.println(Operation.mult(f1, f2));
        System.out.println("скаляр*вектор:");
        System.out.println(Operation.mult(f1, vct1));
        System.out.println("скаляр*матрица:");
        System.out.println(Operation.mult(f1, m1));
        System.out.println("------------------------------------------------------------------------");
        System.out.println("вектор*скаляр:");
        System.out.println(Operation.mult(vct1, f1));
        System.out.println("вектор*вектор:");
        System.out.println(Operation.mult(vct1, vct2));
        System.out.println("вектор*вектор:");
        System.out.println(Operation.mult(vct1, vct1));
        System.out.println("вектор*матрица:");
        System.out.println(Operation.mult(vct1, m1));
        System.out.println("вектор*матрица:");
        System.out.println(Operation.mult(vct1, m2));
        System.out.println("------------------------------------------------------------------------");
        System.out.println("матрица*скаляр:");
        System.out.println(Operation.mult(m1, f1));
        System.out.println("матрица*вектор:");
        System.out.println(Operation.mult(m1, vct1));
        System.out.println("матрица*вектор:");
        System.out.println(Operation.mult(m2, vct1));
        System.out.println("матрица*матрица:");
        System.out.println(Operation.mult(m1, m1));
        System.out.println("матрица*матрица:");
        System.out.println(Operation.mult(m1, m2));
        System.out.println("/////////////////////////////////////////////////////////////////////////");

        System.out.println("------------------>>>>>Проверка операций деления<<<<<------------------");
        System.out.println("скаляр/скаляр:");
        System.out.println(Operation.div(f1, f2));
        System.out.println("скаляр/скаляр:");
        System.out.println(Operation.div(f1, null));
        System.out.println("скаляр/вектор:");
        System.out.println(Operation.div(f1, vct1));
        System.out.println("скаляр/матрица:");
        System.out.println(Operation.div(f1, m1));
        System.out.println("------------------------------------------------------------------------");
        System.out.println("вектор/скаляр:");
        System.out.println(Operation.div(vct1, f2));
        System.out.println("вектор/вектор:");
        System.out.println(Operation.div(vct2, vct1));
        System.out.println("вектор/матрица:");
        System.out.println(Operation.div(vct1, m1));
        System.out.println("------------------------------------------------------------------------");
        System.out.println("матрица/скаляр:");
        System.out.println(Operation.div(m2, f2));
        System.out.println("матрица/вектор:");
        System.out.println(Operation.div(m2, vct1));
        System.out.println("матрица/матрица:");
        System.out.println(Operation.div(m2, m1));
        System.out.println("/////////////////////////////////////////////////////////////////////////");
    }
}