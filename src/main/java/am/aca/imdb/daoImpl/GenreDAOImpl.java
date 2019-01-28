package am.aca.imdb.daoImpl;

import am.aca.imdb.dao.GenreDAO;
import am.aca.imdb.entity.Genre;
import am.aca.imdb.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public abstract class GenreDAOImpl implements GenreDAO {

    private EntityManager entityManager;

    @Autowired
    public GenreDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Genre> findAll() {
        TypedQuery query = entityManager.createQuery("from Genre", Genre.class);
        List<Genre> genres = query.getResultList();
        return genres;
    }




}
