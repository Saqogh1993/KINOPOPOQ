package am.aca.imdb.repository.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "country")
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "country_id")
    private Long countryId;

    @Column(name = "country_name")
    private String countryName;

    @OneToMany(mappedBy = "country", targetEntity = Movie.class)
    private Set<Movie> movies = new HashSet<>();

    public Country() {
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Set<Movie> getMovieSet() {
        return movies;
    }

    public void setMovieSet(Set<Movie> movieSet) {
        this.movies = movieSet;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String name) {
        this.countryName = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + (countryId == null ? 0 : countryId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(countryId, obj);
    }

}
