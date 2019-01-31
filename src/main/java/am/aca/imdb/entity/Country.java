package am.aca.imdb.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "country")
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private long countryId;
    @Column(name = "country_name")
    private String countryName;
    @OneToMany(mappedBy = "countries", cascade = {CascadeType.ALL}, targetEntity = Movie.class)
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

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public Set<Movie> getMovieSet() {
        return movies;
    }

    public void setMovieSet(Set<Movie> movies) {
        this.movies = movies;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String name) {
        this.countryName = name;
    }

}
