package by.it.akhmelev.jd01_10.annotations.sample_service;

@Service(name="Very Lazy Service",lazyLoad = true)
public class LazyService{

    @Init
    public void start() throws Exception{
        System.out.println("Very Lazy Service started");
    }

    public void  stop(){
        System.out.println("Very Lazy Service stopped");
    }

    public LazyService() {
        System.out.println("Создан экземпляр Very Lazy Service");
    }
}
