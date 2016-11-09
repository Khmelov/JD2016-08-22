package by.it.opiga.JD02_03;

public class Runner {
    static int countBuyers = 0;
    static int countsecond = 0;
    static int shopHours = 60;
    volatile static int countCashiers = 0; //общий счетчик кассиров

    public static void main(String[] arg) throws InterruptedException {
        //Queue<Buyer> queue = new ArrayDeque<>();

//        while (countsecond <= shopHours) {
//            if (countsecond <= 30) {
//                Thread.sleep(1000);
//                countsecond++;
//                int count = Helper.random(0, 2);//столько приходит покупатедей
//                for (int i = 0; i < count; i++) {
//                    Buyer buyer = new Buyer(++countBuyers);
//                    queue.add(buyer);
//                }
//            }
//            countsecond++;  }
        //создаем очередь для покупателей. Пока обычную.
        while (countBuyers < 30) {
            Thread.sleep(1000); //ожидание в 1 секунду
            int count = Helper.random(0, 2);
            for (int i = 0; i <= count; i++) {
                countBuyers++;
                if (countBuyers < 11) {
                    new Buyer(countBuyers);
                }
            }
        }
    }

    }

