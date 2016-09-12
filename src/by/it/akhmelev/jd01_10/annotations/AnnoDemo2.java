package by.it.akhmelev.jd01_10.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class AnnoDemo2 {
    //цель - метод
    @Target(value = ElementType.METHOD)
    @Retention(value = RetentionPolicy.RUNTIME)
    public @interface StartObject {
    }

    //цель - метод
    @Target(value = ElementType.METHOD)
    @Retention(value = RetentionPolicy.RUNTIME)
    public @interface StopObject {
    }

    //цель - метод
    @Target(value = ElementType.TYPE)
    @Retention(value = RetentionPolicy.RUNTIME)
    public @interface ControlledObject {
        String name();

    }
    //===============================================================
    //аннотируемый класс
    @ControlledObject(name="biscuits")
    public class Cookies {

        @StartObject
        public void createCookie(){
            //бизнес логика
        }
        @StopObject
        public void stopCookie(){
            //бизнес логика
        }
    }


    //метод, проверяющий наличие аннотаций
    private void AnnotationReact() throws ClassNotFoundException {
        Class cl = Class.forName("[... путь ...]Cookies"); //загружаем класс
        //был аннотирован класс или нет
        if(!cl.isAnnotationPresent(ControlledObject.class)){
            System.err.println("no annotation");
        } else {
            System.out.println("class annotated ; name  -  " + cl.getAnnotation(ControlledObject.class));
        }
        //теперь проверим аннотированы ли методы
        boolean hasStart=false;
        boolean hasStop=false;
        Method[] method = cl.getMethods();
        for(Method md: method){
            if(md.isAnnotationPresent(StartObject.class)) {hasStart=true;}
            if(md.isAnnotationPresent(StopObject.class)) {hasStop=true;}
            if(hasStart && hasStop){break;}
        }
        System.out.println("Start annotaton  - " + hasStart + ";  Stop annotation  - " + hasStop );

        Set<Integer> s=new HashSet();

    }



}
