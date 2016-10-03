package by.it.prymshyts.jd01.jd01_13.matlab;

public class Calculator implements IOperation {

    private Operation addOperation = new AddOperation();
    private Operation subOperation = new SubOperation();
    private Operation mulOperation = new MulOperation();
    private Operation divOperation = new DivOperation();


    @Override
    public Variable add(Variable firstVar, Variable secondVar) {
        return addOperation.add(firstVar, secondVar);
    }
    @Override
    public Variable sub(Variable firstVar, Variable secondVar) {
        return subOperation.sub(firstVar, secondVar);
    }
    @Override
    public Variable mul(Variable firstVar, Variable secondVar) {
        return mulOperation.mul(firstVar, secondVar);
    }
    @Override
    public Variable div(Variable firstVar, Variable secondVar) {
        return divOperation.div(firstVar, secondVar);
    }
}
