package by.it.prymshyts.matlab;

public abstract class Operation implements IOperation {

    @Override
    public Variable add(Variable firstVar, Variable secondVar) {
        Console.println("Сложение невозможно.");
        return null;
    }

    @Override
    public Variable sub(Variable firstVar, Variable secondVar) {
        Console.println("Вычитание невозможно.");
        return null;
    }

    @Override
    public Variable mul(Variable firstVar, Variable secondVar) {
        Console.println("Умножение невозможно.");
        return null;
    }

    @Override
    public Variable div(Variable firstVar, Variable secondVar) {
        Console.println("Деление невозможно.");
        return null;
    }
}
