package am.aca.imdb.service.dto;

import am.aca.imdb.repository.entity.Language;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LanguageDto implements Serializable {

    private long id;
    private String name;
    private List<String> movieName;

    public List<String> getMovieName() {
        return movieName;
    }

    public void setMovieName(List<String> movieName) {
        this.movieName = movieName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<LanguageDto> mapEntitiesToDto(List<Language> languages) {
        List<LanguageDto> languageList = new ArrayList<>();
        if (languages == null)
            return null;

        for (Language language : languages) {
            languageList.add(LanguageDto.mapEntityToDto(language));
        }

        return languageList;
    }

    public static LanguageDto mapEntityToDto(Language language) {
        if (language == null)
            return null;

        LanguageDto languageDto = new LanguageDto();

        languageDto.setId(language.getLanguageName().hashCode());
        languageDto.setName(language.getLanguageName());
        languageDto.setMovieName(language.getMovies().stream().map(m -> m.getTitle()).collect(Collectors.toList()));

        return languageDto;
    }

    public static Language mapDtoToEntity(LanguageDto languageDto) {
        if (languageDto == null)
            return null;

        Language language = new Language();
        language.setLangId(languageDto.getId());
        language.setLanguageName(languageDto.getName());
        return language;
    }
}
