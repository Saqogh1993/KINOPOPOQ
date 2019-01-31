package am.aca.imdb.mappers;

import am.aca.imdb.dto.LanguageDto;
import am.aca.imdb.entity.Language;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LanguageMapper implements MapEntityToDto<Language, LanguageDto> {
    @Override
    public LanguageDto mapEntityToDto(Language entity) {
        LanguageDto languageDto = new LanguageDto();
        languageDto.setLangId(entity.getLangId());
        languageDto.setLangName(entity.getLanguageName());
        return languageDto;
    }

    @Override
    public List<LanguageDto> mapEntitiesToDto(List<Language> entities) {
        return entities.stream().
                map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }
}
