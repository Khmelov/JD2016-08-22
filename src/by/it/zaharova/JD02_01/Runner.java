package by.it.zaharova.JD02_01;


public class Runner {
    static int countSeconds = 0;
    static int countBuyers = 0;
    protected volatile static int countCashiers = 0;
    public static void main(String[] args){
        //создадим кассы

        while (countSeconds++ < 10) {
            try {
                Thread.sleep(1000);
                int n = Helper.random(0,2);
                for (int i = 0; i < n; i++) {
                    new Buyer(++countBuyers);
                    if (countBuyers < 11) {
                        new Buyer(countBuyers);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

}
