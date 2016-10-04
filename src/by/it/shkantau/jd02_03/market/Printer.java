package by.it.shkantau.jd02_03.market;

 class Printer {
    public synchronized static void print(String string){
        System.out.println(string);
    }
}
