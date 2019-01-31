package am.aca.imdb.dto;

import java.util.List;

public class CountryDto {
    private Long countryId;
    private String countryName;
    private List<String> countryMovies;

    public List<String> getCountryMovies() {
        return countryMovies;
    }

    public void setCountryMovies(List<String> countryMovies) {
        this.countryMovies = countryMovies;
    }

    public CountryDto() {
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
