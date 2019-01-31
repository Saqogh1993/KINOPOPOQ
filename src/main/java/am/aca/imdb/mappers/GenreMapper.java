package am.aca.imdb.mappers;

import am.aca.imdb.dto.GenreDto;
import am.aca.imdb.entity.Genre;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GenreMapper implements MapEntityToDto<Genre, GenreDto> {
    @Override
    public GenreDto mapEntityToDto(Genre entity) {
        GenreDto genreDto = new GenreDto();
        genreDto.setGenreId(entity.getGenreId());
        genreDto.setGenreName(entity.getGenreName());
        return genreDto;
    }

    @Override
    public List<GenreDto> mapEntitiesToDto(List<Genre> entities) {
        return entities.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }
}
