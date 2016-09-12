package by.it.akhmelev.jd01_10.matlab_prototype.vars;

import by.it.akhmelev.jd01_10.matlab_prototype.Patterns;
import by.it.akhmelev.jd01_10.matlab_prototype.interfaces.IVar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс описывающий вектор
 */
public class  VarV extends Var implements IVar{
    private double[] vector;
    // =============== конструкторы класса ==================================
    public VarV(String str) { //конструктор из строки
        setFrom(str);
    }

    VarV(double[] vector) { //конструктор из массива
        this.vector = new double[vector.length];
        System.arraycopy(vector, 0, this.vector, 0, vector.length);
    }

    VarV(VarV init) { //конструктор-копия (можно также реализовать clone)
        this.vector = new double[init.vector.length];
        System.arraycopy(init.vector, 0, this.vector, 0, this.vector.length);
    }

    //==== Операции, их лучше вынести в отдельный класс, так просто понятнее ===
    /**
     * Cложение v1+v2
     * @param var v2
     * @return Var v1+v2
     */
    @Override //сложение v1+v2
    public Var add(Var var) {
        // --------------------------------------------------------------------
        if (var instanceof VarV) //проверим, является ли аргумент вектором
        // to do тут еще нужна проверка на одинаковый размер операндов this и v2
        {
            VarV v1 = new VarV(this);             //первый операнд
            VarV v2 = (VarV)var;                  //второй
            for (int i = 0; i < v1.vector.length; i++) {    //считаем
                v1.vector[i] = v1.vector[i] + v2.vector[i]; //основная операция
            }
            return v1;                                      //выводим итог
        }
        // --------------------------------------------------------------------
        if (var instanceof VarF) //проверим, является ли аргумент скаляром
        {
            VarV v1 = new VarV(this);                 //первый операнд
            double v2 = ((VarF) var).getValue();   //второй
            for (int i = 0; i < v1.vector.length; i++) {    //считаем
                v1.vector[i] = v1.vector[i] + v2;           //основная операция
            }
            return v1;                                      //выводим итог
        }
        // --------------------------------------------------------------------
        //если аргумент не скаляр и не вектор, то больше ничего не сделать, вызываем суперкласс
        return super.add(var);
    }

    /**
     * вычитание v1-v2
     * @param var v2
     * @return Var (v1-v2)
     */
    @Override //вычитание v1-v2
    public Var sub(Var var) {
        // --------------------------------------------------------------------
        if (var instanceof VarV) //проверим, является ли аргумент вектором
        // to do тут еще нужна проверка на одинаковый размер операндов this и v2
        {
            VarV v1 = new VarV(this);             //первый операнд
            VarV v2 = (VarV)var;                  //второй
            for (int i = 0; i < v1.vector.length; i++) {    //считаем
                v1.vector[i] = v1.vector[i] - v2.vector[i]; //основная операция
            }
            return v1;                                      //выводим итог
        }
        // --------------------------------------------------------------------
        if (var instanceof VarF) //проверим, является ли аргумент скаляром
        {
            VarV v1 = new VarV(this);                 //первый операнд
            double v2 = ((VarF) var).getValue();   //второй
            for (int i = 0; i < v1.vector.length; i++) {    //считаем
                v1.vector[i] = v1.vector[i] - v2;           //основная операция
            }
            return v1;                                      //выводим итог
        }
        // --------------------------------------------------------------------
        //если аргумент не скаляр и не вектор, то больше ничего не сделать, вызываем суперкласс
        return super.sub(var);
    }

    /**
     * Умножение v1*v2
     * @param var v2
     * @return Var (v1*v2)
     */
    @Override
    public Var mul(Var var) {
        // --------------------------------------------------------------------
        if (var instanceof VarV) //проверим, является ли аргумент вектором
        // to do тут еще нужна проверка на одинаковый размер операндов this и var
        {
            double f=0;
            VarV v1 = new VarV(this);             //первый операнд
            VarV v2 = (VarV)var;                  //второй
            for (int i = 0; i < v1.vector.length; i++) {    //скалярное произведение
                f = f +(v1.vector[i] * v2.vector[i]);       //основная операция
            }
            return new VarF(f);                          //выводим итог
        }
        // --------------------------------------------------------------------
        if (var instanceof VarF) //проверим, является ли аргумент скаляром
        {
            VarV v1 = new VarV(this);             //первый операнд
            double v2 = ((VarF) var).getValue();         //второй
            for (int i = 0; i < v1.vector.length; i++) {    //считаем
                v1.vector[i] = v1.vector[i] * v2;           //основная операция
            }
            return v1;                                      //выводим итог
        }
        // --------------------------------------------------------------------
        //если аргумент не скаляр и не вектор, то больше ничего не сделать, вызываем суперкласс
        return super.sub(var);
    }

    @Override
    public Var div(Var var) {
        // --------------------------------------------------------------------
        if (var instanceof VarF) //проверим, является ли аргумент скаляром
        {
            VarV v1 = new VarV(this);             //первый операнд
            double v2 = ((VarF) var).getValue();         //второй
            for (int i = 0; i < v1.vector.length; i++) {    //считаем
                v1.vector[i] = v1.vector[i] / v2;           //основная операция
            }
            return v1;                                      //выводим итог
        }
        // --------------------------------------------------------------------
        //если аргумент не скаляр, то больше ничего не сделать, вызываем суперкласс
        return super.div(var);
    }



    //=================== вспомогательные опреации, заполнение класса и наоборот ====
    //преобразование в строку
    @Override
    public String toString() {
        StringBuilder res=new StringBuilder("");
        String prefix="{";
        for (Double val:vector) {
            res.append(prefix).append(val.toString());
            prefix=", ";
        }
        return res.append("}").toString();
    }

    //заполнение из строки
    @Override
    public void setFrom(String str) {
    String[] elem=str.split(",");
    vector=new double[elem.length];
    Matcher m=Pattern.compile(Patterns.exVal).matcher(str);
    int i=0;
    while (m.find()) {
        vector[i]=Double.parseDouble(m.group());
        i++;
        }
    }
}
