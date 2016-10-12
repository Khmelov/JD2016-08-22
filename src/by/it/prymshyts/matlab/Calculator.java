package by.it.prymshyts.matlab;

class Calculator {

    static private Operation addOperation = new AddOperation();
    static private Operation subOperation = new SubOperation();
    static private Operation mulOperation = new MulOperation();
    static private Operation divOperation = new DivOperation();


    static public Variable add(Variable firstVar, Variable secondVar) {
        return addOperation.add(firstVar, secondVar);
    }
    static public Variable sub(Variable firstVar, Variable secondVar) {
        return subOperation.sub(firstVar, secondVar);
    }
    static public Variable mul(Variable firstVar, Variable secondVar) {
        return mulOperation.mul(firstVar, secondVar);
    }
    static public Variable div(Variable firstVar, Variable secondVar) {
        return divOperation.div(firstVar, secondVar);
    }
}
