package am.aca.imdb.web.rest;

import am.aca.imdb.repository.dao.LanguageDao;
import am.aca.imdb.repository.entity.Language;
import am.aca.imdb.service.dto.LanguageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LanguageRestController {
    private LanguageDao languageDao;
    @Autowired
    public LanguageRestController(LanguageDao languageDao) {
        this.languageDao = languageDao;
    }

    @GetMapping("/languages")
    public List<LanguageDto> findAllLanguages(){
        return LanguageDto.mapEntitiesToDto(languageDao.findAll());
    }
}
