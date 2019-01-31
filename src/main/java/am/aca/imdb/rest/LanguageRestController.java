package am.aca.imdb.rest;

import am.aca.imdb.dao.LanguageDao;
import am.aca.imdb.dto.LanguageDto;
import am.aca.imdb.mappers.LanguageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class LanguageRestController {
    @Autowired
    private LanguageMapper languageMapper;
    private LanguageDao languageDao;
    public LanguageRestController(LanguageDao languageDao) {
        this.languageDao = languageDao;
    }
    @GetMapping("/languages")
    public List<LanguageDto> findAllLanguages() {
        return languageMapper.mapEntitiesToDto(languageDao.findAll());
    }
}
