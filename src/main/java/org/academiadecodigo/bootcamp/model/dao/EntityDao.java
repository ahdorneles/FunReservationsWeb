package org.academiadecodigo.bootcamp.model.dao;

import org.academiadecodigo.bootcamp.model.Entity;
import org.academiadecodigo.bootcamp.model.User;

/**
 * Created by codecadet on 08/04/2017.
 */
public interface EntityDao extends Dao<Entity>   {
    public Entity findByName(String name);
}
