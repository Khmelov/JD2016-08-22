package by.it.grechishnikov.project.webapp.dao;

import java.util.List;

public interface InterfaceDAO<Type> {
    boolean create(Type obj);
    Type read(int id);
    boolean update(Type obj);
    boolean delete(int id);

    List<Type> getAll();
}