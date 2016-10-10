package by.it.voronovich.JD02_04.Interface;

/**
 * @author Voronovich Dmitry
 * @version 1.1
 */
public interface IVariable {

    Object getValue();
    void setValue(Object value);

    /**
     * Имя переменной
     *
     * @param name имя переменной
     * @return true/false
     */
    boolean saveVar(String name);

    /**
     * Получить значение переменной по имени
     * @param name имя переменной
     * @return значение переменной
     */
    Object readVar(String name);

    String toString();
}