package by.it.prymshyts.jd01.jd01_13.matlab;

public abstract class Variable implements IVariable {

    @Override
    public Object getValue() {
        Log.print("В классе отсутствует поле value.");
        return null;
    }

    @Override
    public void setValue(Object value) {
        Log.print("В классе отсутствует поле value.");
    }

    @Override
    public String toString() {
        Log.print("Функция toString() для Variable не реализована.");
        return null;
    }
}
