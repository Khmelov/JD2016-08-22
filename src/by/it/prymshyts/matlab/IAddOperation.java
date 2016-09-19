package by.it.prymshyts.matlab;

public interface IAddOperation {
    Variable add(FloatVariable firstVar, FloatVariable secondVar);      // Double + Double
    Variable add(FloatVariable firstVar, VectorVariable secondVar);     // Double + Double[]
    Variable add(FloatVariable firstVar, MatrixVariable secondVar);     // Double + Double[][]

    Variable add(VectorVariable firstVar, FloatVariable secondVar);     // Double[] + Double
    Variable add(VectorVariable firstVar, VectorVariable secondVar);    // Double[] + Double[]

    Variable add(MatrixVariable firstVar, FloatVariable secondVar);     // Double[][] + Double
    Variable add(MatrixVariable firstVar, MatrixVariable secondVar);    // Double[][] + Double[][]
}
