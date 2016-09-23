package by.it.kisel.JD01_08d;

public abstract class Surgeon implements Doctor {

    private boolean state = false;

    public boolean isState() {
        return state;
    }

    @Override
    public void operate() {
        state = true;
    }

    @Override
    public void cantOperate() {
        state = false;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public abstract void showState();

    @Override
    public void canHelp() {
        System.out.println("Может вылечить :D");
    }

    @Override
    public void cantHelp() {
        System.out.println("К сожалению, не сможет вылечить..");
    }
}
