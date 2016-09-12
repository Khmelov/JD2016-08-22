package by.it.akhmelev.jd01_10.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public class AnnoDemo {
    @Target(ElementType.TYPE)
    public @interface BaseAction {
        int level();
        String sqlRequest();
    }

    @BaseAction (
            level = 2,
            sqlRequest = "SELECT * FROM phonebook"
    )
    public class Base {
        public void doAction() {
            Class<Base> f = Base.class;
            BaseAction a = (BaseAction)f.getAnnotation(BaseAction.class);
            System.out.println(a.level());
            System.out.println(a.sqlRequest());
        }
    }
}
