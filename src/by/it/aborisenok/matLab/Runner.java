package by.it.aborisenok.matLab;

/**
 * Created by Лёша on 09.09.2016.
 */
public class Runner {
    public static void main(String[] args) {
        Var f1 = new VarF(1);
        Var f2 = new VarF(2);
        Var v1 = new VarV(new double[] {1, 2, 3});
        Var v2 = new VarV(new double[] {1, 2, 3});
        Var vn = new VarV(new double[] {1, 2, 3, 4});
        Var m1 = new VarM(new double[][]{{1,2},{3,4}});
        Var m4 = new VarM(new double[][]{{2,2},{2,2}});
        Var mn = new VarM(new double[][]{{1,1},{1,1},{1,1}});

//
        Var f3 =f1.add(f2);
        System.out.println("Сумма скаляров = " + f3);


        Var v3 = v1.add(f1);
        System.out.println("Сумма вектора и скаляра = " + v3);


        Var v4 = f1.add(v1);
        System.out.println("Сумма скаляра и вектора = " + v4);


        Var v5 = v1.add(v2);
        System.out.println("Сумма двух ветров = " + v5);

        Var v6 = v1.add(vn);
        System.out.println("Сумма двух разноразмерных ветров = " + v6);

        Var m2 = m1.add(f1);
        System.out.println("Сумма сумма матрицы и числа = " + m2);

        Var m3 = f1.add(m1);
        System.out.println("Сумма сумма числа и матрицы = " + m3);

        Var m5 = m1.add(m4);
        System.out.println("Сумма сумма матрицы и матрицы = " + m5);

        Var m6 = m1.add(mn);
        System.out.println("Сумма сумма разноразмерных матриц = " + m6);
    }
}
