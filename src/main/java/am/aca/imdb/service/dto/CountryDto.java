package am.aca.imdb.service.dto;

import am.aca.imdb.repository.entity.Country;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CountryDto implements Serializable {

    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<CountryDto> mapEntitiesToDto(List<Country> countries){
        List<CountryDto> countryDtos = new ArrayList<>();
        if(countries == null)
            return null;

        for (Country country : countries) {
            countryDtos.add(CountryDto.mapEntityToDto(country));
        }
        return countryDtos;
    }

    public static CountryDto mapEntityToDto(Country country) {
        if (country == null)
            return null;

        CountryDto countryDto = new CountryDto();
        countryDto.setId(country.getCountryName().hashCode());
        countryDto.setName(country.getCountryName());

        return countryDto;
    }

    public static Country mapDtoToEntity(CountryDto countryDto){
        if (countryDto == null)
            return null;

        Country country = new Country();
        country.setCountryId(countryDto.getId());
        country.setCountryName(countryDto.getName());

        return country;
    }
}










