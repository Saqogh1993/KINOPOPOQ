package am.aca.kinopopoq.repository.dao;

import am.aca.kinopopoq.repository.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Movie findByMvId(Long id);
    Movie findByTitle(String title);
    List<Movie> findAllByActorsName(String name);
    List<Movie> findAllByGenres(String name);

   @Query("SELECT m FROM Movie m  WHERE m.title LIKE %:title%")
   List<Movie> findMoviesByTitle(@Param("title") String title);
//   @Query("SELECT m FROM Movie m WHERE m.actors LIKE %:actor%")
//   List<Movie> findMoviesByActors(@Param("actor") String actor);

}
