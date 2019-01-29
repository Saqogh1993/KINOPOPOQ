package am.aca.imdb.daoImpl;

import am.aca.imdb.dao.LanguageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
@Repository
@Transactional(readOnly = true)
public abstract class LanguageDaoImpl implements LanguageDao {
    private EntityManager entityManager;
    @Autowired
    public LanguageDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
