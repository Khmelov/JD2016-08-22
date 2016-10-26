package by.it.grechishnikov.jd03_03.dao;

import java.util.List;

public interface InterfaceDAO<Type> {
    void create(Type obj);
    Type read(int id);
    Type update(Type obj);
    boolean delete(int id);

    List<Type> getAll();
}