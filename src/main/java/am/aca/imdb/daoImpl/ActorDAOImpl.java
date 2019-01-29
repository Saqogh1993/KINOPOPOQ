package am.aca.imdb.daoImpl;

import am.aca.imdb.dao.ActorDao;
import am.aca.imdb.entity.Actor;
import am.aca.imdb.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public abstract class ActorDaoImpl implements ActorDao {

    private EntityManager entityManager;

    @Autowired
    public ActorDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



}
