package am.aca.imdb.repository.dao;

import am.aca.imdb.repository.entity.Movie;
import am.aca.imdb.service.dto.ActorDto;
import am.aca.imdb.service.dto.MovieDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieDao extends JpaRepository<Movie, Long> {

}
