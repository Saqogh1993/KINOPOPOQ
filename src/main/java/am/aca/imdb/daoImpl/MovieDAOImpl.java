package am.aca.imdb.daoImpl;

import am.aca.imdb.dao.MovieDAO;
import am.aca.imdb.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public abstract class MovieDAOImpl implements MovieDAO {
    private EntityManager entityManager;

    @Autowired
    public MovieDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Movie> findAll() {
        TypedQuery query = entityManager.createQuery("from Movie", Movie.class);
        List<Movie> movies = query.getResultList();
        return movies;
    }
}
