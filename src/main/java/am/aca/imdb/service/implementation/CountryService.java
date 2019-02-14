package am.aca.imdb.service.implementation;

import am.aca.imdb.repository.dao.CountryRepository;
import am.aca.imdb.service.dto.CountryDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CountryService {

    private CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<CountryDto> findAllCountries() {
        return CountryDto.mapEntitiesToDto(countryRepository.findAll());
    }
}
