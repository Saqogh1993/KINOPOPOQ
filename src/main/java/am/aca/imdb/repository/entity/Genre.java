package am.aca.imdb.repository.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "genre")
public class Genre implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "genre_id")
    private long genreId;

    @Column(name = "genre_name")
    private String genreName;

    @ManyToMany(mappedBy = "genres", cascade = {CascadeType.ALL})
    private Set<Movie> movies = new HashSet<>();


    public Genre() {
    }

    public Genre(String genreName) {
        this.genreId = genreName.hashCode();
        this.genreName = genreName;
    }

    public long getGenreId() {
        return genreId;
    }

    public void setGenreId(long genreId) {
        this.genreId = genreId;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
