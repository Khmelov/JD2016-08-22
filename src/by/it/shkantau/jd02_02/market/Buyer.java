package by.it.shkantau.jd02_02.market;


import java.util.Currency;
import java.util.Locale;

class Buyer implements Runnable, IBuyer, IUseBucket {

   private Bucket bucket;
   private String name;
//   private PriceList priceList;
   private double timeCoefficient;
   private long timeCounter;

    Buyer(Integer number){
       name = "" + number;
//       priceList = new PriceList();
       timeCoefficient = 1.0;
       timeCounter = 0;
   }

    Buyer(Integer number, String nameAddition, double timeCoefficient){
       name = "Buyer №" + number+nameAddition;
//       priceList = new PriceList();
       this.timeCoefficient = timeCoefficient;
       timeCounter = 0;
   }

   @Override
   public void run(){
       enterToMarket();
       takeBucket();
       chooseGoods();
       waitService();


       goToOut();
   }

   @Override
   public void enterToMarket() {
       System.out.println(this + " enter the shop. " + (double)(System.currentTimeMillis() - RunnerMarket.getStartMils())/1000);
   }

   @Override
   public void chooseGoods() {
       timeCounter += sleepRandomInterval(500, 2000);
       System.out.println(this + " choose the goods. " + (double)(System.currentTimeMillis() - RunnerMarket.getStartMils())/1000);
       int countChoosesGoods = Helper.random(1,4);
           for (int i = 0; i < countChoosesGoods; i++) {
               putGoodToBucket(RunnerMarket.getPriceList().getRandomGoods(), (double) Helper.random(1,5));
           }
   }

   @Override
   public void goToOut() {
       System.out.printf("%s leave the shop, spendMoney=%.2f %s,   %.3f\n",
               this, bucket.getTotalSum(), Currency.getInstance(new Locale("ru", "ru")), (double)(System.currentTimeMillis() - RunnerMarket.getStartMils())/1000);
// kill buyer from List<Buyer>buyersList
       synchronized (RunnerMarket.getBuyersList()) {
           RunnerMarket.getBuyersList().remove(this);
       }
   }

    @Override
    public void waitService() {
        System.out.println(this + " became in a queue. " + (double)(System.currentTimeMillis() - RunnerMarket.getStartMils())/1000);
        synchronized (Queues.queueOfBuyers) {
            Queues.queueOfBuyers.addLast(this);
        }
        synchronized (this) {
            try {
                System.out.println(this + " waiting in a queue. "+ (double)(System.currentTimeMillis() - RunnerMarket.getStartMils())/1000);
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println(this + " leave a queue." + (double)(System.currentTimeMillis() - RunnerMarket.getStartMils())/1000);
            }
        }

    }

    @Override
   public String toString() {
       return  "Buyer" + name;
   }

   @Override
   public void takeBucket() {

       timeCounter += sleepRandomInterval(100, 200);
       bucket = new Bucket();
       System.out.println(this + " take a bucket. " + (double)(System.currentTimeMillis() - RunnerMarket.getStartMils())/1000);
   }

   @Override
   public void putGoodToBucket(Goods goods , Double count) {

       timeCounter += sleepRandomInterval(100,200);
       bucket.putGoods(goods, count);
       System.out.println(this + " choose good " + goods.getName() + " in quantity " + count.toString() + (double)(System.currentTimeMillis() - RunnerMarket.getStartMils())/1000);

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
