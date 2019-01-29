package am.aca.imdb.rest;

import am.aca.imdb.dao.LanguageDao;
import am.aca.imdb.entity.Language;
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
    public List<Language> findAllLanguages(){
        List<Language> languages = languageDao.findAll();
        return languages;
    }
}
