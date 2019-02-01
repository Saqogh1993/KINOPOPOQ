package am.aca.imdb.service.daoImpl;

import am.aca.imdb.repository.dao.DirectorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional(readOnly = true)
public abstract class DirectorDaoImpl implements DirectorDao {

    private EntityManager entityManager;
    @Autowired
    public DirectorDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
