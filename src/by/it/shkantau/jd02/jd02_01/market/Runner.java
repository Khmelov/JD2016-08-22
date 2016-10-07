package by.it.shkantau.jd02.jd02_01.market;

public class Runner {

    private static int countSeconds = 0;
    private static int countBuyer = 0;

    public static void main(String[] args) throws InterruptedException {

        while (countSeconds++ < 10){
                Thread.sleep(1000);

//                int  buyersPerSecond;
//                    if ((countBuyer /30)%2 == 0){
//                        buyersPerSecond =   Helper.random(0, 2);
//                    }else{
//                        buyersPerSecond =  Helper.random(0, 2);
//                    }

                for (int i = 0; i <= Helper.random(0, 2); i++) {
                    if (((++countBuyer)%4) == 0){
                        new Thread(new Buyer(countBuyer, "Pensioner", 1.5)).start(); //pensioner
                    }else{
                        new Thread(new Buyer(countBuyer)).start(); // simple mortal
                    }

                }
        }
    }
}
