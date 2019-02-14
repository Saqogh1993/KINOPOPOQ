package am.aca.imdb.service.implementation;

import am.aca.imdb.repository.dao.LanguageRepository;
import am.aca.imdb.service.dto.LanguageDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LanguageService {

    private LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public List<LanguageDto> findAllLanguages(){
        return LanguageDto.mapEntitiesToDto(languageRepository.findAll());
    }
}
