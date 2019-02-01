package am.aca.imdb.web.rest;

import am.aca.imdb.repository.dao.LanguageRepository;
import am.aca.imdb.service.dto.LanguageDto;
import am.aca.imdb.service.implementation.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LanguageRestController {

    private LanguageService languageService;

    public LanguageRestController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/languages")
    public List<LanguageDto> findAllLanguages(){
        return languageService.findAllLanguages();
    }
}
