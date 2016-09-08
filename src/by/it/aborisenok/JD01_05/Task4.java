package by.it.aborisenok.JD01_05;

/**
 * Created by Лёша on 06.09.2016.
 */
public class Task4 {
    public static void solution() {
        System.out.println("Task 4");
        double sum = 0;

        for (int x = 1; x <= 8; x += 1){
            for (int i = 6; i <= 11; i++){
                double y = Math.pow(x,(5 + 1.3*i));
                sum += y;
            }
        }
        System.out.printf("Итоговая сумма = %.2f \n", sum);
    }
}
