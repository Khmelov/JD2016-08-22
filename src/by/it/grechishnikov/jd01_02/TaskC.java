package by.it.grechishnikov.jd01_02;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Evgeniy on 24.08.16.
 */
public class TaskC {
    private static int[][] matrix;
    private static int size;

    public static void matrix() {
        //Задание С
        System.out.println("Введите n - размер матрицы a[n][n]");
        size = Util.getInt();
        matrix = createMatrix();
        printMatrix();
        printSum();
        transponirovanie();
        roundMatrix();
        deleteMaxElement();
        moveMinElement();
        moveNull();
    }

    public static int[][] createMatrix() {
        //Создание матрицы
        int[][] matrix = new int[size][size];
        for(int i=0; i<size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = ThreadLocalRandom.current().nextInt(-size, size);
            }
        }
        return matrix;
    }

    public static void printMatrix() {
        //Выводим матрицу на экран
        for(int i=0; i<size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("\t" + matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void printSum() {
        //Вывод суммы между положительными элементами
        label: for(int i=0; i<matrix.length; i++) {
            boolean first = false;
            int sum = 0;
            for (int j = 0; j < matrix.length; j++) {
                int tmp = matrix[i][j];
                if(tmp > 0) {
                    if(!first) {
                        first = true;
                        continue;
                    }
                    else if(first) {
                        if(sum == 0) {
                            System.out.println("Сумма в строке " + (i + 1) + " недоступна");
                            continue label;
                        }
                        System.out.println("Сумма в строке " + (i + 1) + " = " + sum);
                        continue label;
                    }
                }
                else if(first) {
                    sum += tmp;
                }
            }
            System.out.println("Сумма в строке " + (i + 1) + " недоступна");
        }
    }

    public static void transponirovanie() {
        //Транспонирование
        System.out.println("Транспонируем матрицу");
        int[][] tmpMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tmpMatrix[i][j] = matrix[j][i];
            }
        }
        matrix = tmpMatrix;
        printMatrix();
    }

    public static void roundMatrix() {
        //Вращение
        System.out.println("Поворачиваем матрицу на 90 градусов против часовой стрелки");
        int[][] tmpMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            int counter = size - 1;
            for (int j = 0; j < size; j++) {
                tmpMatrix[j][i] = matrix[i][counter--];
            }
        }
        matrix = tmpMatrix;
        printMatrix();
    }

    public static void deleteMaxElement() {
        //Поиск максимума
        int max = matrix[0][0];
        int x = 0;
        int y = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int value = matrix[i][j];
                if(max < value) {
                    max = value;
                    x = j;
                    y = i;
                }
            }
        }
        System.out.println("Максимальное значение в матрице = " + max);
        delete(x, y);
        printMatrix();
    }

    public static void delete(int x, int y) {
        System.out.println("Удаляем строку и столбец с макс. значением");
        //Удаление из массива
        size--;
        int[][] tmp = new int[size][size];
        int oldX = 0;
        int oldY;
        for (int i = 0; i < size; i++) {
            oldY = 0;
            if(i != y) {
                for (int j = 0; j < size; j++) {
                    if (j != x) {
                        tmp[i][j] = matrix[oldX][oldY];
                    } else {
                        tmp[i][j] = matrix[oldX][++oldY];
                    }
                    oldY++;
                }
            } else {
                oldX++;
                for (int j = 0; j < size; j++) {
                    if (j != x) {
                        tmp[i][j] = matrix[oldX][oldY];
                    } else {
                        tmp[i][j] = matrix[oldX][++oldY];
                    }
                    oldY++;
                }
            }
            oldX++;
        }
        matrix = tmp;
    }

    public static void moveMinElement() {
        //Поиск минимума
        int min = matrix[0][0];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int value = matrix[i][j];
                if(min > value) {
                    min = value;
                }
            }
        }
        System.out.println("Миниммальное значение в матрице = " + min + ". Перемещаем его в позицию [1,1] перестановкой строк и столбцов");
        //Перемещение
        if(!(min == matrix[0][0])) { //Если он не изначально на первом месте

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if(min == matrix[i][j]) {
                        //Меняем строки
                        int[] tmp = matrix[1];
                        matrix[1] = matrix[i];
                        matrix[i] = tmp;
                        //Меняем столбцы
                        for (int k = 0; k < size; k++) {
                            int tmp2 = matrix[k][1];
                            matrix[k][1] = matrix[k][j];
                            matrix[k][j] = tmp2;
                        }
                    }
                }
            }
        }
        printMatrix();
    }

    public static void moveNull() {
        //Сдвиг нулей
        System.out.println("Сдвигаем \"нули\" вправо");
        for (int i = 0; i < size; i++) {
            int nulCount = 0;
            for (int j = 0; j < size; j++) {
                if(matrix[i][j] == 0) {
                    nulCount++;
                }
            }
            for (int r = 0; r < nulCount; r++) {
                for (int j = 0; j < size; j++) {
                    if(matrix[i][j] == 0 && j != size - 1) {
                        for (int k = j + 1; k < size; k++) {
                            int tmp = matrix[i][k];
                            matrix[i][k] = 0;
                            matrix[i][j] = tmp;
                            j++;
                        }
                    }
                }
            }
        }
        printMatrix();
    }
}
