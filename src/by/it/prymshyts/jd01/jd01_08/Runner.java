package by.it.prymshyts.jd01.jd01_08;

public class Runner {

    public static void main(String[] args) {

        Cupboard cupboard = new Bookcase();

        // Собираем -> разбираем -> собираем -> смотрим состояние.
        cupboard.assemble();
        cupboard.disassemble();
        cupboard.assemble();
        cupboard.checkState();

        // Передвигаем к стене.
        cupboard.moveTo("стене");

        // Поджигаем -> тушим.
        cupboard.ignite();
        cupboard.extinguish();

        // Кладём предмет -> смотрим сколько их всего -> забираем предмет -> помещаем два предмета -> смотрим сколько их всего.
        cupboard.placeItem();
        cupboard.showItems();
        cupboard.takeItem();
        cupboard.placeItem(2);
        cupboard.showItems();

        // Наносим урон -> проверяем состояние -> наносим урон -> проверяем состояние -> чиним -> проверяем состояние.
        cupboard.damage();
        cupboard.checkState();
        cupboard.damage();
        cupboard.checkState();
        cupboard.repair();
        cupboard.checkState();

        // Уничтожаем -> проверяем состояние -> восстанавливаем -> смотрим состояние.
        cupboard.destroy();
        cupboard.checkState();
        cupboard.restore();
        cupboard.checkState();
    }
}
