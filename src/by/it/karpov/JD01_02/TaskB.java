package by.it.karpov.JD01_02;
import java.util.*;


public class TaskB extends Example {
        public void make() {
            int n = Util.getNumber();
            make(new String[]{n + ""});
        }

        public void make(String[] args) {


            int count = 0;
            if(args != null && args.length > 0)
                count = Integer.parseInt(args[0]);

            String interval = getInterval(count);
            if(interval != null)
                System.out.println("Значение " + count +
                        " принадлежит интервалу\n" + interval);
            else
                System.out.println("Значение " + count +
                        " не принадлежит интервалу\n");

        }
    private String getInterval(int count){
        StringBuilder sb = new StringBuilder();
       if(count >= 5 && count<=30)
            sb.append("[5, 30]");

        if(count < 5 && count>=0)
            sb.append("[0, 5)");

        if(count > 30)
            sb.append("(30, inf)");


        return sb.toString();
    }
    //Задание 2

    public void printHor(int start, int end, int row, int col){
        System.out.println("Задание №2.1");
        for (int i = start; i <= end; i++) {
            System.out.print(i + "\t");
            if(i % col == 0)
                System.out.println();}}


        public void Month(){
        System.out.println("Задание №4");
        Scanner in = new Scanner(System.in);
        int a;
        System.out.println("Введите число от 1 до 12");
        System.out.print("Номер месяца = ");
        try{
            a = in.nextInt();
            if(a == 1){System.out.println("Январь");}
            else if (a == 2){System.out.println("Февраль");}
            else if (a == 3){System.out.println("Март");}
            else if (a == 4){System.out.println("Апрель");}
            else if (a == 5){System.out.println("Май");}
            else if (a == 6){System.out.println("Июнь");}
            else if (a == 7){System.out.println("Июль");}
            else if (a == 8){System.out.println("Август");}
            else if (a == 9){System.out.println("Сентябрь");}
            else if (a == 10){System.out.println("Октябрь");}
            else if (a == 11){System.out.println("Ноябрь");}
            else if (a == 12){System.out.println("Декабрь");}
            else {System.out.println("Не существует месяца с таким номером");}
        }
        catch (InputMismatchException e) {
            System.out.println("Неверный номер");
        }
    }
}

