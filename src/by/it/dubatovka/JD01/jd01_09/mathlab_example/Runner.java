package by.it.dubatovka.JD01.jd01_09.mathlab_example;

public class Runner {
    public static void main(String[] args) {
        Var f1=new VarF(1);
        Var f2=new VarF(2);
        Var f3=f1.add(f2);
        System.out.println("Сумма скаляров: "+f3);

        Var v1=new VarV(new double[]{1,2,3});
        Var v2=f1.add(v1);
        System.out.println("Сумма скаляра и вектора: "+v2);




    }




}
