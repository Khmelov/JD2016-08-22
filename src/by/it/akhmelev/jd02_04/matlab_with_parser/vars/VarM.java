package by.it.akhmelev.jd02_04.matlab_with_parser.vars;

public class VarM extends Var {
    //это просто пример ;)
    //класс создается по аналогии с VarV и VarF

    public VarM(String strVar) {
        //тут нужно реализовать создание матрицы
    }

    @Override
    public Var add(Var var) {
        System.out.println("Тест. Работает позднее связывание с VarM->ADD");
        return null;
    }
}
