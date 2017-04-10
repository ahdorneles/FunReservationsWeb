package org.academiadecodigo.bootcamp.model.dao;

import org.academiadecodigo.bootcamp.model.Facility;

/**
 * Created by codecadet on 08/04/2017.
 */
public interface EntityDao extends Dao<Facility>   {
    public Facility findByName(String name);
}
