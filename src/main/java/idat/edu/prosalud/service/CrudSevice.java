package idat.edu.prosalud.service;

import java.util.List;

public interface CrudSevice<T> {

    T finById(Long id);
    List<T> findAll();
    T create(T entity);
    T update(Long id, T entity);
    void delete(Long id);
}
