package am.aca.kinopopoq.service.implementation;

import am.aca.kinopopoq.repository.dao.MovieRepository;
import am.aca.kinopopoq.repository.dao.RatingRepository;
import am.aca.kinopopoq.repository.entity.Movie;
import am.aca.kinopopoq.repository.entity.Rating;
import am.aca.kinopopoq.repository.entity.User;
import am.aca.kinopopoq.service.dto.MovieDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private RatingRepository ratingRepository;

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
    public  List<MovieDto> findMoviesByGenreName(String genre){
        return MovieDto.mapEntitiesToDto(movieRepository.findAllByGenres(genre));
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
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "avgRating"));
        LimitOffsetPageRequest pageable = new LimitOffsetPageRequest(limit, offset, sort);
        return MovieDto.mapEntitiesToDto(movieRepository.findAll(pageable).getContent());
    }

    public Long getAllMoviesCount(){
        return movieRepository.count();
    }

    public MovieDto setRating(Long movieId, Long rating) {
        Movie movie = movieRepository.findByMvId(movieId);
        if (movie == null) {
            throw new ResourceNotFoundException("Movie not found", null);
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();
        boolean exists = false;
        for (Rating ratingExisting : movie.getUserRatings()) {
            if (ratingExisting.getUser().getId().equals(user.getId())) {
                exists = true;
                ratingExisting.setRating(rating);
            }
        }
        if (!exists) {
            Rating ratingEntity = new Rating();
            ratingEntity.setRating(rating);
            ratingEntity.setMovie(movie);
            ratingEntity.setUser(user);
            movie.getUserRatings().add(ratingEntity);
        }
        double avg = movie.getUserRatings().stream().mapToDouble(Rating::getRating).average().orElse(0);
        movie.setAvgRating(avg);

        movieRepository.save(movie);

        return MovieDto.mapEntityToDto(movie);
    }
}
