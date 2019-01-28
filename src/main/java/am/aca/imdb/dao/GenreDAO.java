package am.aca.imdb.dao;

import am.aca.imdb.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreDAO extends JpaRepository<Genre, Long> {
}
