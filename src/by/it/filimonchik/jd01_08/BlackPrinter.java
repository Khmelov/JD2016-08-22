package by.it.filimonchik.jd01_08;

/**
 * Created by Raman.Filimonchyk on 21/09/2016.
 */
public class BlackPrinter extends Printer implements IPrinter {
        private int levelold = 100;
        private Integer level = 0;

        public BlackPrinter(Integer level) {
            this.level = level;
        }

        public BlackPrinter() {

        }

        @Override
        public void showState() {
            if (isState()) {
                System.out.println("Принтер включен");
            }
            else
                System.out.println("Принтер выключен");
            System.out.println("Напечатано " + level + " страниц");
        }

        @Override

    public void setLevel(int level) {
        this.level = level;
    }

        @Override
        public void on() {
            if (!isState()) {
                super.on();
                level = levelold;
            }

        }

        @Override
        public void off () {
            if (isState()) {
                super.off();
                levelold = level;
                level = 0;
            }
        }
        @Override
        public void setState ( boolean state){
            super.setState(state);
            if (state) {
                on();
            } else
                off();
        }
    }
