package hr.ibs.bank.dao;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class CrudDaoImpl<T> implements CrudDao<T> {

    protected CrudRepository<T, Long> repo;

    private List<T> list = new ArrayList<>();

    public List<T> get() {
        list.clear();

        repo.findAll().forEach(list::add);
        return list;
    }

    public Optional<T> getById(long id) {
        return repo.findById(id);
    }

    public void add(T obj) {
        repo.save(obj);
    }

    public int update(long id, T obj) {
        Optional<T> emp = getById(id);
        if(emp.isPresent()) {
            repo.save(obj);
            return 1;
        }
        return 0;
    }

    public int delete(long id) {
        repo.deleteById(id);
        return 1;
    }

}
