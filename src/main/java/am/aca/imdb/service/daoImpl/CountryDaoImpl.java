package am.aca.imdb.service.daoImpl;

import am.aca.imdb.repository.dao.CountryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional(readOnly = true)
public abstract class CountryDaoImpl implements CountryDao {
    private EntityManager entityManager;
    @Autowired
    public CountryDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
