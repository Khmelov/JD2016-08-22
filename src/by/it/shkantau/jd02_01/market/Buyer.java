package by.it.shkantau.jd02_01;


import java.util.Currency;
import java.util.Locale;

 class Buyer implements Runnable, IBuyer, IUseBucket {

    private Bucket bucket;
    private String name;
    private PriceList priceList;
    private double timeCoefficient;
    private long timeCounter;

     Buyer(Integer number){
        name = "Buyer №" + number;
        priceList = new PriceList();
        timeCoefficient = 1.0;
        timeCounter = 0;
    }

     Buyer(Integer number, String nameAddition, double timeCoefficient){
        name = "Buyer №" + number+nameAddition;
        priceList = new PriceList();
        this.timeCoefficient = timeCoefficient;
        timeCounter = 0;
    }

    @Override
    public void run(){
        enterToMarket();
//        takeBucket();
//        chooseGoods();
        waitService();


        goToOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter the shop");
    }

    @Override
    public void chooseGoods() {
        timeCounter += sleepRandomInterval(500, 2000);
        System.out.println(name + " choose the goods");
        int countChoosesGoods = Helper.random(1,4);
            for (int i = 0; i < countChoosesGoods; i++) {
                putGoodToBucket(priceList.getRandomGoods(), (double)Helper.random(1,5));
            }
    }

    @Override
    public void goToOut() {
        System.out.printf("%s leave the shop, spendMoney=%.2f %s, spendTime=%.3f seconds\n",
                name, bucket.getTotalSum(), Currency.getInstance(new Locale("ru", "ru")), (double)timeCounter/1000);
    }

     @Override
     public void waitService() {
         System.out.println(this + " стал в очередь.");
         synchronized (Queues.buyers) {
             Queues.buyers.addLast(this);
         }
         synchronized (this) {
             try {
                 System.out.println(this + "ожидает очереди.");
                 this.wait();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }finally {
                 System.out.println(this + "вышел из очереди");
             }
         }

     }

     @Override
    public String toString() {
        return name;
    }

    @Override
    public void takeBucket() {

        timeCounter += sleepRandomInterval(100, 200);
        bucket = new Bucket();
        System.out.println(name + " take a bucket");
    }

    @Override
    public void putGoodToBucket(Goods goods , Double count) {

        timeCounter += sleepRandomInterval(100,200);
        bucket.putGoods(goods, count);
        System.out.println(name + " choose good " + goods.getName() + " in quantity " + count.toString());

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private long sleepRandomInterval(long milsFrom, long milsTo){
        long res = Helper.randomMilsTime((long)(timeCoefficient * (double) milsFrom), (long)(timeCoefficient * (double)milsTo));
        try {
            Thread.sleep(res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  res;
    }
}
