package by.it.prymshyts.matlab;

public interface IOperation {
    Variable add(Variable firstSum, Variable secondSum);
    Variable sub(Variable firstSub, Variable secondSub);
    Variable mul(Variable firstMul, Variable secondMul);
    Variable div(Variable firstDiv, Variable secondDiv);
}
