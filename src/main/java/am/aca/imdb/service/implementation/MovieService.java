package am.aca.imdb.service.implementation;

import am.aca.imdb.repository.dao.MovieRepository;
import am.aca.imdb.service.dto.MovieDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDto> findAllMovies() {
        return MovieDto.mapEntitiesToDto(movieRepository.findAll());
    }
}
