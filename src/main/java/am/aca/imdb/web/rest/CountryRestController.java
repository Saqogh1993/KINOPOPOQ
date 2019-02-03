package am.aca.imdb.web.rest;

import am.aca.imdb.repository.dao.CountryRepository;
import am.aca.imdb.service.dto.CountryDto;
import am.aca.imdb.service.implementation.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryRestController {

    private CountryService countryService;

    public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/countries")
    public List<CountryDto> findAllCountries() {
        return countryService.findAllCountries();
    }
}
