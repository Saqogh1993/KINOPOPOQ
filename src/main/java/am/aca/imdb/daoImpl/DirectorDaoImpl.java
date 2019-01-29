package am.aca.imdb.daoImpl;

import am.aca.imdb.dao.DirectorDao;
import am.aca.imdb.entity.Director;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public abstract class DirectorDaoImpl implements DirectorDao {

    private EntityManager entityManager;
    @Autowired
    public DirectorDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
