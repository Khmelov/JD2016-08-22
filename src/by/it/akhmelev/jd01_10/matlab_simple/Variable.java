package by.it.akhmelev.jd01_10.matlab_simple;

public class Variable implements IVariable{
    //это класс для переменной. ее значение будет в поле value
    private Double value;

    //пустой конструктор
    public Variable() {
    }

    //конструктор по строке
    public Variable(String string) {
        this.value=Double.valueOf(string);
    }

    //конструктор по значению
    public Variable(Double value) {
        this.value = value ;
    }

    @Override
    public Variable add(Variable varAdd) {
        //приготовим отдельную переменную для результата операции (чтобы не изменялись входные значения)
        Variable out=new Variable();
        //теперь проведем нужную операцию
        out.value=this.value+varAdd.value;
        return out;
    }

    @Override
    public Variable sub(Variable varSub) {
        //приготовим отдельную переменную для результата операции (чтобы не изменялись входные значения)
        Variable out=new Variable();
        //теперь проведем нужную операцию
        out.value=this.value-varSub.value;
        return out;
    }

    @Override
    public Variable mul(Variable varMul) {
        //приготовим отдельную переменную для результата операции (чтобы не изменялись входные значения)
        Variable out=new Variable();
        //теперь проведем нужную операцию
        out.value=this.value*varMul.value;
        return out;
    }

    @Override
    public Variable div(Variable varDiv) {
        //приготовим отдельную переменную для результата операции (чтобы не изменялись входные значения)
        Variable out=new Variable();
        //теперь проведем нужную операцию
        out.value=this.value/varDiv.value;
        return out;
    }

    //теперь осталось проверить этот класс.
    //еще нужен методы вывода значений
    public String toString(){
        return value.toString();
    }

}
