package by.it.akhmelev.jd02_06.p04_builder;

/** "Director" */
class Waiter {
    private PizzaBuilder pizzaBuilder;

    void setPizzaBuilder(PizzaBuilder pb) { pizzaBuilder = pb; }
    Pizza getPizza() { return pizzaBuilder.getPizza(); }

    void constructPizza() {
        pizzaBuilder.createNewPizzaProduct();
        pizzaBuilder.buildDough();
        pizzaBuilder.buildSauce();
        pizzaBuilder.buildTopping();
    }
}
