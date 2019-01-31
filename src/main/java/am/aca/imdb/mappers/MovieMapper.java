package am.aca.imdb.mappers;

import am.aca.imdb.dto.ActorDto;
import am.aca.imdb.dto.MovieDto;
import am.aca.imdb.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieMapper implements MapEntityToDto<Movie, MovieDto> {
    @Autowired
    ActorMapper actorMapper;
    @Override
    public MovieDto mapEntityToDto(Movie entity) {
        MovieDto movieDto = new MovieDto();
        movieDto.setMovieId(entity.getMvId());
        movieDto.setMovieName(entity.getTitle());
        movieDto.setBudget(entity.getBudget());
        movieDto.setYear(entity.getYear());
        movieDto.setRating(entity.getRating());
        movieDto.setDuration(entity.getDuration());
        return movieDto;
    }

    @Override
    public List<MovieDto> mapEntitiesToDto(List<Movie> entities) {
        return entities.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }
}
