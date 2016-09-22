package by.it.prymshyts.jd01_13.matlab;

public interface IDivOperation {
    Variable div(FloatVariable firstVar, FloatVariable secondVar);      // Double / Double

    Variable div(VectorVariable firstVar, FloatVariable secondVar);     // Double[] / Double

    Variable div(MatrixVariable firstVar, FloatVariable secondVar);     // Double[][] / Double
}
