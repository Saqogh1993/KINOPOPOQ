package am.aca.kinopopoq.service.implementation;

import am.aca.kinopopoq.repository.dao.LanguageRepository;
import am.aca.kinopopoq.service.dto.LanguageDto;
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
