package by.it.akhmelev.jd01_10.matlab_in_class;

public class Runner {
    public static void main(String[] args) {
        Var f1=new VarF(1);
        Var f2=new VarF(2);
        Var f3=f1.add(f2);
        System.out.println("Сумма скаляров: "+f3);

        Var v1=new VarV(new double[]{1,2,3});
        Var v2=f1.add(v1);
        System.out.println("Сумма скаляра и вектора: "+v2);

        Var v3=v1.add(f2);
        System.out.println("Сумма вектора и скаляра: "+v3);

        Var v4=v1.add(v1);
        System.out.println("Сумма двух векторов: "+v4);

        Var v5=new VarV(new double[]{1,2});
        Var v6=v1.add(v5);
        System.out.println("Сумма двух разных (по размеру) векторов: "+v6);

        Var m1=new VarM(new double[][]{{1,2},{3,4}});
        Var m2=m1.add(f1);
        System.out.println("Сумма матрицы и числа: "+m2);

        Var m3=f2.add(m1);
        System.out.println("Сумма числа и матрицы: "+m3);

        Var m4=v2.add(m1);
        System.out.println("Сумма матрицы и вектора: "+m4);


    }




}
