package am.aca.imdb.mappers;

import am.aca.imdb.dto.GenreDto;
import am.aca.imdb.dto.MovieDto;
import am.aca.imdb.entity.Genre;
import am.aca.imdb.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class GenreMapper implements MapEntityToDto<Genre, GenreDto> {
    @Autowired
    private MovieMapper movieMapper;
    @Override
    public GenreDto mapEntityToDto(Genre entity) {
        GenreDto genreDto = new GenreDto();
        genreDto.setGenreId(entity.getGenreId());
        genreDto.setGenreName(entity.getGenreName());
        List<MovieDto> movieDtos = movieMapper.mapEntitiesToDto(entity.getMovies());
        List<String> movieNames = movieDtos.stream()
                .map(m -> m.getMovieName())
                .collect(Collectors.toList());
        genreDto.setGenreMovies(movieNames);
        return genreDto;
    }

    @Override
    public List<GenreDto> mapEntitiesToDto(List<Genre> entities) {
        return entities.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }
}
