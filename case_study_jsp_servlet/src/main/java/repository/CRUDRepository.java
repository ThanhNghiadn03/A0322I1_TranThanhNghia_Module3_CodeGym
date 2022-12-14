package repository;

import java.util.List;

public interface CRUDRepository<T> {
    List<T> findAll();
    void insert(T t);
    void deleteById(int id);
    void edit(T t);
}
