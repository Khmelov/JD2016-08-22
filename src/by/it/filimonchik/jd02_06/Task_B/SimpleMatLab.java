package by.it.filimonchik.jd02_06.Task_B;

/**
 * Created by Raman.Filimonchyk on 22/09/2016.
 */

public class SimpleMatLab {
    public static void main(String[] args) {

       try {
           Variable onevalue = new Variable( "1" );

           Variable twovalue = new Variable( "test" );

           Variable resAdd = onevalue.add( twovalue );
           System.out.println( onevalue + "+" + twovalue + "=" + resAdd );

           Variable resSub = onevalue.sub( twovalue );
           System.out.println( onevalue + "-" + twovalue + "=" + resSub );

           Variable resMul = onevalue.mul( twovalue );
           System.out.println( onevalue + "*" + twovalue + "=" + resMul );

           Variable resDiv = onevalue.div( twovalue );
           System.out.println( onevalue + "/" + twovalue + "=" + resDiv );
       }catch (NumberFormatException e)
       {
           System.out.println("Ошибка ввода данных");
           Logger.getInstance().Error(e);
       }
    }
}