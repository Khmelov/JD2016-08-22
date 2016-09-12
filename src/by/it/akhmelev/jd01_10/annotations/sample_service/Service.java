package by.it.akhmelev.jd01_10.annotations.sample_service;

import java.lang.annotation.*;

@Documented //класс помеченный аннотацией Service попадет в JavaDoc
@Inherited  //эта аннотация наследуется потомками помеченного класса
@Target(ElementType.TYPE) //эта аннотация предназначена для пометки класса или интерфейса
@Retention(RetentionPolicy.RUNTIME) //аннотация живет при выполнении

public @interface Service {
    String name();                      //значение в аннотации, указывать обязательно
                                        // @Service(name="Author");

    boolean lazyLoad() default false;   //значение в аннотации, необязательно
                                        // @Service(name="Author",lazyLoad=true);

}
