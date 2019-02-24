package am.aca.kinopopoq.repository.dao;

import am.aca.kinopopoq.repository.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Movie findByMvId(Long id);
    Movie findByTitle(String title);
    List<Movie> findAllByActorsName(String name);
    List<Movie> findAllByGenres(String name);

   @Query(value = "SELECT * FROM movie m  WHERE m.title ILIKE %:title% --#pageable\n", nativeQuery = true)
   List<Movie> findMoviesByTitle(@Param("title") String title, Pageable pageable);

   @Query(value = "SELECT count(m.movie_id) FROM movie m  WHERE m.title ILIKE %:title%", nativeQuery = true)
   Long findMoviesByTitleCount(@Param("title") String title);

    @Override
    Page<Movie> findAll(Pageable pageable);
}
