package by.it.zaharova.JD01_02;

public class TaskA {

    public static String maxLength(String arrStr[]) {
        int max = Integer.MIN_VALUE;
        String result = " ";
        for (String s : arrStr) {
            if (s.length() > max) {
                result = s;
                max = s.length();

            }
        }

        return result;
    }


    public static String minLength(String arrStr[]) {
        int min = Integer.MAX_VALUE;
        String result = " ";
        for (String s : arrStr) {
            if (s.length() < min) {
                result = s;
                min = s.length();

            }
        }

        return result;
    }


    public static double mean(int[] mas){
        double result=0;
        for(int i:mas) result+=i;
        result=result/mas.length;
        return result;
    }

    public static int FindDiff(String arrStr[]){
        for(int i=0; i<arrStr.length; i++){
            boolean find = true;
            char str[]= arrStr[i].toCharArray();
            for (int j = 0; j <str.length ; j++) {
                for (int k = 0; k < str.length ; k++) {
                    if(str[j] == str[k] && j!=k)
                        find = false;
                }
            }
            if (find)
                return Integer.parseInt(arrStr[i]);
        }
        return 0;
    }


}

