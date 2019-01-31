package am.aca.imdb.mappers;

import am.aca.imdb.dto.CountryDto;
import am.aca.imdb.dto.MovieDto;
import am.aca.imdb.entity.Country;
import am.aca.imdb.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Component
public class CountryMapper implements MapEntityToDto<Country, CountryDto> {
    @Autowired
    private MovieMapper movieMapper;
    @Override
    public CountryDto mapEntityToDto(Country entity) {
        CountryDto countryDto = new CountryDto();
        countryDto.setCountryId(entity.getCountryId());
        countryDto.setCountryName(entity.getCountryName());
        List<MovieDto> movieDtos = movieMapper.mapEntitiesToDto(entity.getMovieSet());
        List<String> movieNames = movieDtos.stream()
                .map(m -> m.getMovieName())
                .collect(Collectors.toList());
        countryDto.setCountryMovies(movieNames);
        return countryDto;
    }

    @Override
    public List<CountryDto> mapEntitiesToDto(List<Country> entities) {
        return entities.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }
}
