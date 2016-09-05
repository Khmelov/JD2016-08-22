package by.it.prymshyts.jd01_05;

public class Runner {

    public static void main(String[] args) {

        //double[] array = Task6.getArray(30);
        //Task6.printArray(array, "arr");
        //double[] newArray = Task6.getNewArray(array);
        //Task6.printArray(newArray, "arr");
        //System.out.println(Task6.getGeometricMean(newArray));

        int[] A = Task7.getArrayA();
        int[] B = Task7.getArrayB(A);

        Task7.printArrayA(A);
        Task7.printArrayB(B);
    }
}
