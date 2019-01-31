package am.aca.imdb.rest;

import am.aca.imdb.dao.CountryDao;
import am.aca.imdb.dto.CountryDto;
import am.aca.imdb.entity.Country;
import am.aca.imdb.mappers.CountryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Set;

@RestController
public class CountryRestController {
    @Autowired
    private CountryMapper countryMapper;
    private CountryDao countryDao;
    public CountryRestController(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    @GetMapping("/countries")
    public List<CountryDto> findAllCountries () {
        return countryMapper.mapEntitiesToDto( countryDao.findAll());
    }
}
