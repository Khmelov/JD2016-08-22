package by.it.prymshyts.jd01_05;

import java.lang.reflect.Method;

public class Extra {

    protected static void getMathMethods() {

        Class c = Math.class;
        Method[] methods = c.getMethods();

        for (Method method : methods) {
            System.out.println("Имя: " + method.getName());
            System.out.println("Возвращаемый тип: " + method.getReturnType().getName());

            Class[] paramTypes = method.getParameterTypes();
            System.out.print("Типы параметров: ");
            for (Class paramType : paramTypes) {
                System.out.print(" " + paramType.getName());
            }
            System.out.println("\n----");
        }
    }
}
