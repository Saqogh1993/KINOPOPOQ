package am.aca.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "genre")
public class Genre implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private int genreId;

    @Column(name = "genre_name")
    private String genreName;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "genre_movie",
            joinColumns = {@JoinColumn(name = "genre_id")},
            inverseJoinColumns = {@JoinColumn(name = "movie_id")}
    )
    private Set<Movie> movies = new HashSet<>();

    public Genre() {
    }

    public Genre(String genreName) {
        this.genreId = genreName.hashCode();
        this.genreName = genreName;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
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
