package am.aca.imdb.mappers;

import am.aca.imdb.dto.CountryDto;
import am.aca.imdb.entity.Country;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class CountryMapper implements MapEntityToDto<Country, CountryDto> {
    @Override
    public CountryDto mapEntityToDto(Country country) {
        CountryDto countryDto = new CountryDto();
        countryDto.setCountryId(country.getCountryId());
        countryDto.setCountryName(country.getCountryName());
        return countryDto;
    }

    @Override
    public List<CountryDto> mapEntitiesToDto(List<Country> entities) {
        return entities.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }
}
