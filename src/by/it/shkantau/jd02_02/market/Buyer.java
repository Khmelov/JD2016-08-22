package by.it.shkantau.jd02_02.market;


import java.util.Currency;
import java.util.Locale;

class Buyer implements Runnable, IBuyer, IUseBucket {

   private Bucket bucket;
   private String name;

   private double timeCoefficient;
   private long timeCounter;
    private boolean pensioner;

    Buyer(Integer number){
       name = "" + number;
       timeCoefficient = 1.0;
       timeCounter = 0;
       pensioner = false;
   }

    Buyer(Integer number, boolean pensioner , double timeCoefficient){
       name = "" + number;
       this.timeCoefficient = timeCoefficient;
       this.pensioner = pensioner;
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
       System.out.println(this + " enter the shop. ");
   }

   @Override
   public void chooseGoods() {
       timeCounter += sleepRandomInterval(500, 2000);
//       System.out.println(this + " choose the goods. ");
       int countChoosesGoods = Helper.random(1,4);
           for (int i = 0; i < countChoosesGoods; i++) {
               putGoodToBucket(RunnerMarket.getPriceList().getRandomGoods(), (double) Helper.random(1,5));
           }
   }

   @Override
   public void goToOut() {
       System.out.println(this +" leave the shop");
// kill buyer from List<Buyer>buyersList
       synchronized (RunnerMarket.getBuyersList()) {
           RunnerMarket.getBuyersList().remove(this);
       }
   }

    @Override
    public void waitService() {
//        System.out.println(this + " became in a queue. ");
        synchronized (Queues.queueOfBuyers) {
            Queues.queueOfBuyers.addLast(this);
        }
        synchronized (this) {
            try {
//                System.out.println(this + " waiting in a queue.");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
   public String toString() {
       if(!this.pensioner){
           return  "Buyer" + name;
       }else {
           return "Pensioner" + name;
       }
   }

   @Override
   public void takeBucket() {
       timeCounter += sleepRandomInterval(100, 200);
       bucket = new Bucket();
//       System.out.println(this + " take a bucket. ");
   }

   @Override
   public void putGoodToBucket(Goods goods , Double count) {
       timeCounter += sleepRandomInterval(100,200);
       bucket.putGoods(goods, count);
//       System.out.println(this + " choose good " + goods.getName() + " in quantity " + count.toString() + (double)(System.currentTimeMillis() - RunnerMarket.getStartMils())/1000);
   }

   public String getName() {
       return name;
   }

   public void setName(String name) {
       this.name = name;
   }

    Bucket getBucket() {
        return bucket;
    }

    public void setBucket(Bucket bucket) {
        this.bucket = bucket;
    }

    public boolean isPensioner() {
        return pensioner;
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
