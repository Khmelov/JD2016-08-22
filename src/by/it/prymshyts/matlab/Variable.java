package by.it.prymshyts.matlab;

public abstract class Variable implements IVariable {

    @Override
    public Object getValue() {
        Console.print("В классе отсутствует поле value.");
        return null;
    }

    @Override
    public void setValue(Object value) {
        Console.print("В классе отсутствует поле value.");
    }

    @Override
    public String toString() {
        Console.print("Функция toString() для Variable не реализована.");
        return null;
    }
}
