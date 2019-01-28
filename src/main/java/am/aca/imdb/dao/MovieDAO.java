package am.aca.imdb.dao;

import am.aca.imdb.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDAO extends JpaRepository<Movie, Long> {
}
