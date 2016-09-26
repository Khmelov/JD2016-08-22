package by.it.zaharova.JD01_08Vlada;

public abstract class ForseShip implements Ship{
    private boolean state = false;

    public boolean isState() {
        return state;
    }

    @Override
    public void swimming() {
        state = true;
    }

    @Override
    public void notswimming() {
        state = false;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public abstract void showState();

    @Override
    public void notshoot() {
        System.out.println("Не стреляет. Тебе боеприпасов жалко?");
    }

    @Override
    public void shoot() {
        System.out.println("Стреляет");
    }
}
