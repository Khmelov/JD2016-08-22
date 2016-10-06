package by.it.shkantau.jd02.jd02_01.market;


 class Helper {

    static int random(int from , int to){
        return   from + Math.round((int)((double)(to - from)*Math.random()));
    }

    static long random(double from, double to){
        return  (long) (1000*from +  Math.round(Math.random() * 1000*(to - from)));
    }

    static long randomMilsTime(long milsFrom, long milsTo) {
        return (milsFrom + Math.round(Math.random() * (milsTo - milsFrom)));
    }

}
