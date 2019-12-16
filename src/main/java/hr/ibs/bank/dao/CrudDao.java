package hr.ibs.bank.dao;

import java.util.List;
import java.util.Optional;

public interface CrudDao<T> {

    List<T> get();
    Optional<T> getById(long id);
    void add(T obj);
    int update(long id, T obj);
    int delete(long id);

}
