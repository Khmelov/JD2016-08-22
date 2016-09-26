package by.it.prymshyts.jd01.jd01_08;

import by.it.prymshyts.jd01.jd01_02.Util;

abstract class Cupboard implements IFurniture{

    /**
     * Поля инкапсулируются внутри абстрактного класса.
     * Имеется геттер и сеттер для поля items.
     */

    protected String name;
    private int health;
    private State state;
    private Integer items;

    Cupboard() {
        this.name = "Шкаф";
        this.health = 100;
        this.state = State.DISASSEMBLED;
        this.items = 0;
    }


    @Override
    public void assemble() {
        System.out.println(this.name + " был собран.");
        this.state = State.ASSEMBLED;
    }

    @Override
    public void disassemble() {
        System.out.println(this.name + " был разобран.");
        this.state = State.DISASSEMBLED;
    }


    @Override
    public void moveTo(String to) {
        System.out.println(this.name + " был передвинут к " + to + ".");
    }


    @Override
    public void ignite() {
        System.out.println(this.name + " был подожжён.");
    }

    @Override
    public void extinguish() {
        System.out.println(this.name + " был потушен.");
    }


    @Override
    public void repair() {
        Integer dealtHeal = Util.getRandomNum(1, 100);
        System.out.println(this.name + " был отремонтирован на " + dealtHeal.toString() + ".");
        this.health += Math.max(1, Math.min(100, dealtHeal));

        if (this.health > 0 && this.state == State.DESTROYED) {
            this.restore();
        }
    }

    @Override
    public void damage() {
        Integer dealtDamage = Util.getRandomNum(1, 100);
        System.out.println(this.name + " был повреждён на " + dealtDamage.toString() + ".");
        this.health -= Math.max(1, Math.min(100, dealtDamage));

        if (health <= 0 && this.state != State.DESTROYED) {
            this.destroy();
        }
    }



    public void destroy() {
        System.out.println(this.name + " был уничтожен.");
        this.health = 0;
        this.state = State.DESTROYED;
    }

    void restore() {
        System.out.println(this.name + " был восстановлен.");
        this.health = 100;
        this.state = State.DISASSEMBLED;
    }


    public void checkState() {

        String currentState;

        switch (this.state) {
            case ASSEMBLED:
                currentState = "собран";
                break;

            case DISASSEMBLED:
                currentState = "разобран";
                break;

            case DESTROYED:
                currentState = "уничтожен";
                break;

            default:
                currentState = "кот шредингера";
                break;
        }

        System.out.print(this.name + " сейчас " + currentState + ". ");
        System.out.println("Если бы у него была полоска жизней, то она была бы на отметке " + this.health + ".");
    }


    public void placeItem() {
        items++;
    }

    /**
     * Демонстрация статического полимофризма.
     * Название метода повторяется, но количество передаваемых аргументов иное.
     * @param itemsNumber кастомное количество предметов
     */

    public void placeItem(Integer itemsNumber) {
        setItems(itemsNumber);
    }

    void takeItem() {
        if (items > 0) {
            items--;
        }
    }

    void setItems(Integer items) {
        this.items = items;
    }

    Integer getItems() {
        return items;
    }


    /**
     * Абстрактный метод для его определения в классах наследниках.
     */

    public abstract void showItems();
}
