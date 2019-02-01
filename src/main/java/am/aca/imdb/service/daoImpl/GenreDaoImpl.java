package am.aca.imdb.service.daoImpl;

import am.aca.imdb.repository.dao.GenreDao;
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
