package by.it.dubatovka.jd01_08;

/**
 * Created by Dubatovka Sergey on 18.09.2016.
 */
abstract class PublicBuilding implements IBuild {

    private String openTime;
    private String closeTime;
    private String address;
    private boolean open;
    private int floor;


    PublicBuilding(String address) {
        this.address = address;
        floor = 1;
        openTime = "8:00";
        closeTime = "20:00";
    }


    @Override
    public String getAddress() {
        return address;

    }

    @Override
    public boolean isOpen() {
        return open;
    }

    @Override
    public void open() {
        if (open) {
           System.out.println("Уже открыто.");
        } else open = true;
    }

    @Override
    public void close() {
        if (open) open = false;
        else System.out.println("Уже закрыто.");

    }

    @Override
    public String info() {
        return floor + "-этажное здание, по адресу: " + address;
    }

    @Override
    public int getFloor() {
        return floor;
    }

    /**
     * Статический полиморфизм.
     *
     * @return Время работы общественного здания.
     */
    public String workTime() {

        return openTime + " - " + closeTime;
    }

    /**
     * Статический полисорфизм.
     *
     * @param openTime  Время открытия.
     * @param closeTime Время закрытия.
     * @return Время работы общественного здания.
     */
    public String workTime(String openTime, String closeTime) {
        this.openTime = openTime;
        this.closeTime = closeTime;

        return openTime + " - " + closeTime;
    }


}
