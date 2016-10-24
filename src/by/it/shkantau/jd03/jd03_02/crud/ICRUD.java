package by.it.shkantau.jd03.jd03_02.crud;

import java.util.List;

 interface  ICRUD <T> {
    T read(int id);
    int create(T entity);
    int update(T entity);
    int delete(T entity);
    List<T> getAll(String WhereAndOrder);
}
