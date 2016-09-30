package by.it.akhmelev.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class th3_01_Atomics {

    private AtomicInteger atomicCount =new AtomicInteger(0);

    //целостная ссылка на что-то
    private final AtomicReference<Object> init = new AtomicReference<>();
    private Object someObject=new Object();

    void run() {
        Object o1=new Object();
        if (!init.compareAndSet(someObject, o1)) {
            throw new IllegalStateException("Already initialized");
        }
        Object prev=init.getAndSet(o1);
        init.set(someObject);
        int prevCount= atomicCount.getAndAdd(10);
    }







}
