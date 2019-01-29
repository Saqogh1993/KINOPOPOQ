package am.aca.imdb.daoImpl;

import am.aca.imdb.dao.MovieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional(readOnly = true)
public abstract class MovieDaoImpl implements MovieDao {
    private EntityManager entityManager;
    @Autowired
    public MovieDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
