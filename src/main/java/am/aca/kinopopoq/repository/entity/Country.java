package am.aca.kinopopoq.repository.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "country")
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "country_id")
    private long countryId;

    @Column(name = "country_name")
    private String countryName;

    @OneToMany(mappedBy = "country", cascade = {CascadeType.ALL}, targetEntity = Movie.class)
    private Set<Movie> movies = new HashSet<>();

    public Country() {
    }

    public Country(String countryName) {
        this.countryId = countryName.hashCode();
        this.countryName = countryName;
    }

    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
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

}