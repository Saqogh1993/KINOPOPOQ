package am.aca.imdb.repository.dao;

import am.aca.imdb.repository.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Movie findByMvId(Long id);
    Movie findByTitle(String string);
    List<Movie> findAllByActorsName(String name);
}
