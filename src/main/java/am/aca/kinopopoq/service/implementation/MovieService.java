package am.aca.kinopopoq.service.implementation;

import am.aca.kinopopoq.repository.dao.MovieRepository;
import am.aca.kinopopoq.service.dto.MovieDto;
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

    public MovieDto findMovieById(Long id) {
        return MovieDto.mapEntityToDto(movieRepository.findByMvId(id));
    }

    public MovieDto findMovieByTitle(String string) {
        return MovieDto.mapEntityToDto(movieRepository.findByTitle(string));
    }
    public List<MovieDto> findMoviesByActorName(String name){
        return MovieDto.mapEntitiesToDto(movieRepository.findAllByActorsName(name));
    }
}
