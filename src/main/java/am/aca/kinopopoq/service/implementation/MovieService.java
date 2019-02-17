package am.aca.kinopopoq.service.implementation;

import am.aca.kinopopoq.repository.dao.MovieRepository;
import am.aca.kinopopoq.repository.entity.Movie;
import am.aca.kinopopoq.service.dto.MovieDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public MovieService() {
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

    public MovieDto saveMovie(MovieDto movieDto) {
        Movie movie = MovieDto.mapDtoToEntity(movieDto);
        movie.setMvId(null);
        movieRepository.save(movie);
        return MovieDto.mapEntityToDto(movie);
    }

    public MovieDto updateMovie(MovieDto movieDto) {
        Movie movie = MovieDto.mapDtoToEntity(movieDto);
        movieRepository.save(movie);
        return MovieDto.mapEntityToDto(movie);
    }

    public void deleteMovie(Long id) {
        movieRepository.delete(id);
    }

    public List<MovieDto> findAllMoviesWithPages(int limit, int offset){
        LimitOffsetPageRequest pageable = new LimitOffsetPageRequest(limit, offset);
        return MovieDto.mapEntitiesToDto(movieRepository.findAll(pageable).getContent());
    }
}
