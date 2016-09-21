package by.it.voronovich.MathLab.Var;

import java.util.ArrayList;

public class VariableMatrix extends Variable {

    private double[][] value;
    private int row;
    private int col;

    /**
     * Конструктор преобразования в матрицу
     * @param value  double[][]
     */
    public VariableMatrix(double[][] value) {
        this.value = new double[value.length][value[0].length];
        this.row = value.length;
        this.col = value[0].length;
        for (int i = 0; i < value.length; i++) {
            System.arraycopy(value[i], 0, this.value[i], 0, value[i].length);
        }
    }

    /**
     * Конструктор преобразующий строку в объект VariableMatrix
     * @param variableMatrix строка
     */
    public VariableMatrix(String variableMatrix) {
        int row = 0;
        int col = 0;
        String[] rows = variableMatrix.split("\\{\\{|\\},\\{|\\}\\}");

        ArrayList<String> array = new ArrayList<>();
        for (int i = 0; i < rows.length; i++) {
            if (!rows[i].isEmpty())
                array.add(rows[i]);
        }

        //определеляем число строк и столбцов матрицы
        row = array.size();
        for (int i = 0; i < array.size(); i++) {
            String[] arrCol = array.get(i).split(",");
            col = arrCol.length;
        }

        double[][] result = new double[row][col];
        for (int i = 0; i < row; i++) {
            String[] tmp = array.get(i).split(",");
            for (int j = 0; j < col; j++) {
                result[i][j] = Double.valueOf(tmp[j]);
            }
        }
        this.value = result;
        this.row = value.length;
        this.col = value[0].length;
    }

    public double[][] getValue() {
        return value;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public String toString() {

        for (int i = 0; i < this.value.length; i++) {
            for (int j = 0; j < this.value[0].length; j++) {
                System.out.printf("[%1d,%1d]=%-7.2f",i+1, j+1, this.value[i][j]);
            }
            System.out.println();
        }

        return "";
    }

}