package am.aca.imdb.mappers;

import am.aca.imdb.dto.MovieDto;
import am.aca.imdb.entity.Movie;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieMapper implements MapEntityToDto<Movie, MovieDto> {
    @Override
    public MovieDto mapEntityToDto(Movie entity) {
        MovieDto movieDto = new MovieDto();
        movieDto.setMovieId(entity.getMvId());
        movieDto.setMovieName(entity.getTitle());
        return movieDto;
    }

    @Override
    public List<MovieDto> mapEntitiesToDto(List<Movie> entities) {
        return entities.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }
}
