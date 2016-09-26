package by.it.kisel.JD01_08d;

public class Neurosurgeon extends Surgeon implements Doctor {

    private int countOld = 100;
    private Integer count = 0;

    @Override
    public void showState() {
        if (isState()) {
            System.out.println("Операция возможна");
        } else {
            System.out.println("Операция невозможна :(");
        }
        System.out.println("Таблеток назначено " + count);
        if (count > 30) canHelp();
        else cantHelp();
        System.out.println();
    }

    @Override
    public void giveMedicines(int count) {
        this.count = count;
    }

    @Override
    public void operate() {
        if (!isState()) {
            super.operate();
            count = countOld;
        }
    }

    @Override
    public void cantOperate() {
        if (isState()) {
            super.cantOperate();
            countOld = count;
            count = 0;
        }
    }

    @Override
    public void setState(boolean state) {
        if (state != isState()) {
            super.setState(state);
            if (state) {
                operate();
            } else {
                cantOperate();
            }
        }
    }
}
