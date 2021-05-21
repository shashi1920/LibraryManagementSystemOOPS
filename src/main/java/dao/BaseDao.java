package dao;

import java.util.List;

public interface BaseDao<T> {

    List<T> findAll();
    T save(T item);
    T findById(Long id);
    T update(T item);
    void delete(T item);
}
