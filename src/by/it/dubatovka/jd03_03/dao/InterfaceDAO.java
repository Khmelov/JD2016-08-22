package by.it.dubatovka.jd03_03.dao;

import java.util.List;

public interface InterfaceDAO<T> {
    T read(int id);

    boolean create(T entity);

    boolean update(T entity);

    boolean delete(T entity);

    List<T> getAll(String WhereAndOrder);


}
