package am.aca.kinopopoq.web.rest;

import am.aca.kinopopoq.service.dto.CountryDto;
import am.aca.kinopopoq.service.implementation.CountryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/countries")
public class CountryRestController {

    private CountryService countryService;

    public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/")
    public List<CountryDto> findAllCountries() {
        return countryService.findAllCountries();
    }
}
