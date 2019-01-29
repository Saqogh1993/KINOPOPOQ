package am.aca.imdb.daoImpl;

import am.aca.imdb.dao.ActorDAO;
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
public abstract class ActorDAOImpl implements ActorDAO {

    private EntityManager entityManager;

    @Autowired
    public ActorDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



}
