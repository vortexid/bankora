package hr.ibs.bank.service;


import hr.ibs.bank.dao.CrudDao;

import java.util.List;

public abstract class DataService<T> {

    protected CrudDao<T> dao;

    public List<T> getList() { return dao.get(); }

    public void add(T obj) { dao.add(obj); }

    public void update(long id, T obj) { dao.update(id, obj); }

    public void delete(long id) {  dao.delete(id); }

}
