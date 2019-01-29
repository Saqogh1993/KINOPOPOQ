package am.aca.imdb.daoImpl;

import am.aca.imdb.dao.GenreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional(readOnly = true)
public abstract class GenreDaoImpl implements GenreDao {
    private EntityManager entityManager;
    @Autowired
    public GenreDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
