package by.it.filimonchik.jd03_03.DAO;

import java.util.List;

/**
 * Created by Raman.Filimonchyk on 07/11/2016.
 */
    interface IDAO<TYPE> {
    TYPE read(int id);

    boolean create(TYPE entity);

    boolean update(TYPE entity);

    boolean delete(TYPE entity);

    List<TYPE> getAll(String WhereAndOrder);
}
