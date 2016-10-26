package by.it.prymshyts.jd03.jd03_03.dao;

import java.util.List;

public interface InterfaceDAO<T> {

    T read(int id);

    boolean create(T entity);
    boolean update(T entity);
    boolean delete(T entity);

    List<T> getAll();
    List<T> getAll(String condition);
}
