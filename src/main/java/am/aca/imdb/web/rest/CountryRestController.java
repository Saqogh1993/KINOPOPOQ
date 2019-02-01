package am.aca.imdb.web.rest;

import am.aca.imdb.repository.dao.CountryDao;
import am.aca.imdb.service.dto.CountryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryRestController {

    @Autowired
    private CountryDao countryDao;

    @GetMapping("/countries")
    public List<CountryDto> findAllCountries() {
        return CountryDto.mapEntitiesToDto(countryDao.findAll());
    }
}
