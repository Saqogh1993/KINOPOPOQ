package am.aca.imdb.repository.dao;

import am.aca.imdb.repository.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreDao extends JpaRepository<Genre, Long> {

}
