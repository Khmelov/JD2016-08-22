package by.it.prymshyts.jd01.jd01_13.VariantC;

/**
 * Класс наследует все методы и поля абстрактного класса Cupboard.
 */

class Bookcase extends Cupboard {

    Bookcase() {
        this.name = "Книжный шкаф";
    }

    @Override
    public void showItems() {
        String bookName = getCorrectSpell(getItems());
        System.out.println("На полках сейчас " + getItems().toString() + " " + bookName + ".");
    }

    @Override
    public void ignite() {
        super.ignite();
        setItems(0);
        System.out.println("Все книги сгорели.");
    }

    /**
     * Демонстрация динамического полиморфизма.
     * Метод вызывает поведение супера и затем определяет дополнительные действия.
     */

    @Override
    public void destroy() {
        super.destroy();
        setItems(0);
        System.out.println("Книги разлетелись во все стороны.");
    }

    @Override
    public void placeItem() {
        super.placeItem();
        System.out.println("На полку положена одна книга.");
    }

    @Override
    public void placeItem(Integer itemsNumber) {
        super.placeItem(itemsNumber);
        String bookName = getCorrectSpell(itemsNumber);
        System.out.println("На полку положено " + itemsNumber.toString() + " " + bookName + ".");
    }

    private String getCorrectSpell(Integer itemsNumber) {

        String correctSpell;

        if (itemsNumber == 1) {
            correctSpell = "книга";
        } else if ((itemsNumber > 1 && itemsNumber <= 4) || (itemsNumber > 20 && (itemsNumber % 10 >= 1 && itemsNumber % 10 <= 4))) {
            correctSpell = "книги";
        } else {
            correctSpell = "книг";
        }

        return correctSpell;
    }
}
