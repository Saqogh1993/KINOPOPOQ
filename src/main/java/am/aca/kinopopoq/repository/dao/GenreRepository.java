package am.aca.kinopopoq.repository.dao;

import am.aca.kinopopoq.repository.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    Genre findGenreByGenreName(String name);

}
