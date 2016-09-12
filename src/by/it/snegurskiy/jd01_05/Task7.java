package by.it.snegurskiy.jd01_05;

/**
 * Created by snegurskiy.nn on 06.09.2016.
 */
public class Task7 {

    //сформировать массив А(31) и заполнить рандом значениями от 103 до 450 и округлить до целых
    public static double[] getArray() {
        double[] array = new double[31];
        for (int i = 0; i < array.length ; i++) {
            array[i] = (int) (Math.random() * 347 + 103);
            }
        //создать массив В включающий только те у которых значение больше 10% индекса в А
        double[] arrayB = new double[31];
        int colNull=0;
        for (int i = 0; i < arrayB.length; i++) {
            if (array[i] * 0.1 > i) {
                arrayB[i] = array[i];
                colNull++;
            }
        }
        // отсортировать массив по возрастанию и убрать нули
        for (int i = 0; i <arrayB.length ; i++) {
            for (int j = i+1; j <arrayB.length ; j++) {
                if (arrayB[i]>arrayB[j]){
                    double col=arrayB[i];
                    arrayB[i]=arrayB[j];
                    arrayB[j]=col;
                }
            }
        }
        double [] arrayBSort=new double[colNull];
        for (int i = 0; i <arrayBSort.length; i++) {
            arrayBSort[i]=arrayB[i+arrayB.length-colNull];
            }
        System.out.println();
        Util05.arrayOnePrint(arrayBSort);
        System.out.println();
        Util05.arrayOnePrintHorizont(array,"A",5);
        Util05.arrayOnePrintHorizont(arrayBSort,"B",5);
        System.out.println();
        Util05.arrayOnePrintVertical(arrayBSort,"B",5);

        return array;
    }

    //вывести массивы А и В с границами не более 5 столбцов с нумерацией, А - горизонтально, В - Вертикально
}
