package org.academiadecodigo.bootcamp.model.dao;

import java.util.List;

public interface Dao<T> {

    /**
     * Persists the dao object as a user table row
     *
     * @param dao the dao object to persist
     */
    public void save(T dao);

    /**
     * Deletes the row corresponding to the dao object from the database table
     *
     * @param dao
     */
    public void delete(T dao);

    /**
     * Returns a new dao object corresponding to the database table row matching provided name
     *
     * @param name
     * @return
     */
    public T findByName(String name);

    /**
     * Returns a collection view of the entire database table
     *
     * @return the list view
     */
    public List<T> findAll();

    /**
     * Returns the number of rows on the database table
     *
     * @return
     */
    public long count();

}
