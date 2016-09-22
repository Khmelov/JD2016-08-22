package by.it.opiga.JD01_08;

/**
 * Created by Asus on 21.09.2016.
 */
public class Main {

    public static void main(String[ ] args) {
        //создание танкера
        CargoShip tank1=new Tanker(70,6000);
        System.out.println("текущее состояние: "+tank1.showState());
        tank1.stand();  // корабль остановили
        System.out.println(tank1.showState());
        tank1.loaded();//загружается
        System.out.println(tank1.showState());
        tank1.filled();//загружен
        System.out.println(tank1.showState());
        tank1.swim(); //корабль поплыл
        System.out.println(tank1.showState());

        Tanker tank2=new Tanker( );
        tank2.setMaxVesGruza(5000);
        tank2.getMaxVesGruza();

        //динамический полиморфизм
        CargoShip tank3=new ChemicalTanker(50,70,5000,90,"Olga");
        System.out.println(tank3.toString());
        CargoShip tank4=new Tanker();
        System.out.println(tank4.toString());

        //анонимный класс
        ChemicalTanker tank5=new ChemicalTanker() {
             {  String s;
                if(getColTanks()>100)
                    s=Type.Oil.toString();
                else if(getColTanks()<100)
                    s=Type.Chemical.toString();
                else s="unknown";
                setType(s);
                System.out.println("Корабль "+getName()+" "+getKomandir()+" "+getColTanks());
                System.out.println("Тип корабля "+getType());
            }
        };
        System.out.println(tank5.hashCode());
    }
}
