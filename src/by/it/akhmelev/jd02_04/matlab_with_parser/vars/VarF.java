package by.it.akhmelev.jd02_04.matlab_with_parser.vars;

import by.it.akhmelev.jd02_04.matlab_with_parser.interfaces.*;


/** Класс для операций со скалярными величинами */
public class VarF extends Var implements IVar, IAdd,ISub,IMul,IDiv {
    private double value;

    // =============== конструкторы класса ==================================
    //получаем из строки
    public VarF(String str) {
        setFrom(str);
    }

    //получаем из числа
    public VarF(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }


    //=========== Операции, их лучше вынести в отдельный класс ==============
    @Override //сложение f1+f2
    public Var add(Var var) {
        if (var instanceof VarF) //проверим, является ли аргумент скаляром
            return new VarF(this.value + ((VarF)var).value); //выводим итог
        //если аргумент не скаляр, то меняем местами операнды f2+f1
        return var.add(this);
    };

    @Override //разность f1-f2
    public Var sub(Var var) {
        if (var instanceof VarF) //проверим, является ли аргумент скаляром
            return new VarF(this.value - ((VarF)var).value); //выводим итог
        //если аргумент не скаляр, то меняем местами операнды (-1)*(f2-f1)
        VarF minus=new VarF(-1); //готовим -1
        return minus.mul(var.sub(this)); //выводим итог = (-1)*(f2-f1)
    };

    @Override //умножение f1*f2
    public Var mul(Var var) {
        if (var instanceof VarF) //проверим, является ли аргумент скаляром
            return new VarF(this.value * ((VarF)var).value); //выводим итог
        //если аргумент не скаляр, то меняем местами операнды f2+f1
        return var.mul(this);
    };

    @Override //деление f1/f2
    public Var div(Var var) {
        if (var instanceof VarF) //проверим, является ли аргумент скаляром
            return new VarF(this.value / ((VarF)var).value); //выводим итог
        //если аргумент не скаляр, то на него делить нельзя, вызываем базовый класс
        return super.div(var);
    };

    //=================== вспомогательные опреации, заполнение класса и наоборот ====
    @Override
    public String toString() {
        return ((Double)value).toString();
    }

    @Override
    public void setFrom(String str) {
        value=Double.valueOf(str);
    }
}
