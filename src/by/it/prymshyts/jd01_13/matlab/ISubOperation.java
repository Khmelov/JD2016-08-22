package by.it.prymshyts.jd01_13.matlab;

public interface ISubOperation {
    Variable sub(FloatVariable firstVar, FloatVariable secondVar);      // Double - Double
    Variable sub(FloatVariable firstVar, VectorVariable secondVar);     // Double - Double[]
    Variable sub(FloatVariable firstVar, MatrixVariable secondVar);     // Double - Double[][]

    Variable sub(VectorVariable firstVar, FloatVariable secondVar);     // Double[] - Double
    Variable sub(VectorVariable firstVar, VectorVariable secondVar);    // Double[] - Double[]

    Variable sub(MatrixVariable firstVar, FloatVariable secondVar);     // Double[][] - Double
    Variable sub(MatrixVariable firstVar, MatrixVariable secondVar);    // Double[][] - Double[][]
}
