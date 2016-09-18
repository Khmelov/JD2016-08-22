package by.it.dubatovka.jd01_08;

import java.util.Random;

class Theatre extends PublicBuilding {

    private String name;
    private int freePlaces;

    Theatre(String address, int freePlaces) {
        super(address);
        this.freePlaces = freePlaces;
        name = "Театр";
    }

    public String getName() {
        return name;
    }

    public int getFreePlaces() {            //инкапсуляция
        return freePlaces;
    }

    public Ticket buyTicket() {
        if (isOpen()) {
            if (freePlaces > 0) {
                freePlaces--;
                return new Ticket();
            } else {
                System.out.println("Билетов нет.");
                return null;
            }
        } else {
            System.out.println("Театр закрыт. Вы не можете приобрести билет");
            return null;
        }
    }


    public void show(Ticket bilet) {
        if (isOpen()) {
            if (bilet != null) {
                System.out.println("Ваш ряд: " + bilet.row + "\nВаше место: " + bilet.number);
                System.out.println("Приятного просмотра!");
            } else {
                System.out.println("У вас нет билета.");
            }
        } else System.out.println("Театр закрыт. Вы не можете посмотреть спектакль");
    }


    class Ticket {

        private int row;
        private int number;

        Ticket() {
            Random random = new Random();
            row = random.nextInt(20) + 1;
            number = random.nextInt(100) + 1;
        }
    }

    /**
     * Динамический полиморфизм
     *
     * @return Выводит режим работы театра.
     */
    @Override
    public String workTime() {
        String workTime = super.workTime();
        return name + "\nВремя работы:" + workTime;
    }

    @Override
    public String workTime(String openTime, String closeTime) {
        return name + "\nВремя работы:" + super.workTime(openTime, closeTime);
    }
//наследование метода из родительского класса
    @Override
    public String info() {
        String str = isOpen() ? "Открыто." : "Закрыто.";
        return name + ". " + getFloor() + "-этажное здание, по адресу: " +
                getAddress() + " В данный момент " + str;
    }


}
