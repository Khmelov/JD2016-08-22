package by.it.zaharova.JD01_08Vlada;


public class AircraftCarrier extends ForseShip implements Ship{

    private int countOld = 100;
    private Integer count = 0;

    @Override
    public void showState() {
        System.out.println("Колчество боеприпасов " + count);
        if (count<20) notshoot();
        else shoot();

        if (isState()) {
            System.out.println("Плывет");

        } else {
            System.out.println("Не плывет");
        }
    }

    @Override
    public void setAmmo(int count) {
        this.count=count;
    }

    @Override
    public void swimming() {
        if (!isState()) {
            super.swimming();
            count = countOld;
        }
    }

    @Override
    public void notswimming() {
        if (isState()) {
            super.notswimming();
            countOld = count;
            count = 0;
        }
    }

    @Override
    public void setState(boolean state) {
        if (state != isState()) {
            super.setState(state);
            if (state) {
                swimming();
            } else {
                notswimming();
            }
        }
    }
}
