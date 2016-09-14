package by.it.karpov.JD01_02;

public class TaskA {
    static String getMax(int array[]) {
        int lenMax = 0;
        Integer max = Integer.MIN_VALUE;
        for (Integer i : array) {
            if (max < i) {
                max = i;
            }
        }
    return "MAX=" +max.toString()+ " length=" + max.toString().length();
    }
    static String getMin(int array[]) {
        int lenMax = 0;
        Integer min = Integer.MAX_VALUE;
        for (Integer i : array) {
            if (min > i) {
                min = i;
            }
        }
        return "MIN=" +min.toString()+ " length=" + min.toString().length();
}
    static double mean(int array[]){
        double res=0;
        for (int i:array) res=res+i;
        res/=array.length;
        return res;
    }
    static boolean difNumb(Integer value){
        char ch[]=value.toString().toCharArray();
        for (int i = 0; i <ch.length ; i++){
            for (int j = i+1; j <ch.length ; j++)
            if (ch[i]==ch[j])
                return false;}
        return true;
        }
    }

