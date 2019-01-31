package am.aca.imdb.mappers;

import am.aca.imdb.dto.LanguageDto;
import am.aca.imdb.dto.MovieDto;
import am.aca.imdb.entity.Language;
import am.aca.imdb.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class LanguageMapper implements MapEntityToDto<Language, LanguageDto> {
    @Autowired
    private MovieMapper movieMapper;
    @Override
    public LanguageDto mapEntityToDto(Language entity) {
        LanguageDto languageDto = new LanguageDto();
        languageDto.setLangId(entity.getLangId());
        languageDto.setLangName(entity.getLanguageName());
        List<MovieDto> movieDtos = movieMapper.mapEntitiesToDto(entity.getMovies());
        List<String> movieNames = movieDtos.stream()
                .map(m -> m.getMovieName())
                .collect(Collectors.toList());
        languageDto.setLangMovies(movieNames);
        return languageDto;
    }

    @Override
    public List<LanguageDto> mapEntitiesToDto(List<Language> entities) {
        return entities.stream().
                map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }
}
