package com.project.domain.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDao <E,ID> {

    public void save(E t);
    public void update(E t);
    public  void  delete(ID id);
    public Optional<E> find(ID id);
    public List<E> getAll();

}
