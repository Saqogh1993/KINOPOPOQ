package am.aca.imdb.service.daoImpl;

import am.aca.imdb.repository.dao.ActorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional(readOnly = true)
public abstract class ActorDaoImpl implements ActorDao {

    private EntityManager entityManager;

    @Autowired
    public ActorDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



}
