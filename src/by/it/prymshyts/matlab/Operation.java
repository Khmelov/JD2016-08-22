package by.it.prymshyts.matlab;

public abstract class Operation implements IOperation {

    @Override
    public Variable add(Variable firstVar, Variable secondVar) {
        Log.println("Сложение невозможно.");
        return null;
    }

    @Override
    public Variable sub(Variable firstVar, Variable secondVar) {
        Log.println("Вычитание невозможно.");
        return null;
    }

    @Override
    public Variable mul(Variable firstVar, Variable secondVar) {
        Log.println("Умножение невозможно.");
        return null;
    }

    @Override
    public Variable div(Variable firstVar, Variable secondVar) {
        Log.println("Деление невозможно.");
        return null;
    }
}
