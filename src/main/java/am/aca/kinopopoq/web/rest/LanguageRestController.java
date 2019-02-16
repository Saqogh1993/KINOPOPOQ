package am.aca.kinopopoq.web.rest;

import am.aca.kinopopoq.service.dto.LanguageDto;
import am.aca.kinopopoq.service.implementation.LanguageService;
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
