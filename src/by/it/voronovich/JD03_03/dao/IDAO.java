package by.it.voronovich.JD03_03.dao;


import java.util.List;

public interface IDAO<TYPE> {
    //READ чтение отдельной сущности
    TYPE read(int id);
    //CREATE,UPDATE,DELETE обновление сущности
    boolean create(TYPE entity);
    boolean update(TYPE entity);
    boolean delete(TYPE entity);

    //READ - чтение всех элементов по условию
    List<TYPE> getAll(String WhereAndOrder);
    //и другие необходимые системе операции
}
