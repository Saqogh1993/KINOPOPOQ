package am.aca.imdb.rest;

import am.aca.imdb.dao.CountryDao;
import am.aca.imdb.daoImpl.CountryDaoImpl;
import am.aca.imdb.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryRestController {
    private CountryDao countryDao;
    @Autowired
    public CountryRestController(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    @GetMapping("/countries")
    public List<Country> findAllCountries(){
        return countryDao.findAll();
    }
}
