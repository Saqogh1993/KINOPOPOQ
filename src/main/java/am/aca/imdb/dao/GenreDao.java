package am.aca.imdb.dao;

import am.aca.imdb.dto.GenreDto;
import am.aca.imdb.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreDao extends JpaRepository<Genre, Long> {
}
