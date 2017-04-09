package org.academiadecodigo.bootcamp.model.dao.hibernate;

import org.academiadecodigo.bootcamp.model.Entity;
import org.academiadecodigo.bootcamp.model.dao.EntityDao;
import org.academiadecodigo.bootcamp.persistence.hibernate.HibernateSessionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by codecadet on 08/04/2017.
 */

@Repository
@Transactional
public class HibernateEntityDao extends HibernateDao<Entity> implements EntityDao {


    public HibernateEntityDao() {
    }

    public HibernateEntityDao(HibernateSessionManager sessionManager) {
        super(Entity.class, sessionManager);
    }

    @Override
    public Entity findByName(String name) {
        return null;
    }
}

