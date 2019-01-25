package am.aca.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "genre_id")
    private int genreId;

    @Column(name = "genre_name")
    private String genreName;
    @ManyToMany(mappedBy = "genres", cascade = {CascadeType.ALL})
    private Set<Movie> movies = new HashSet<>();

    public Genre() {
    }

    public Genre(String genreName) {
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

    public void setGenreName(String name) {
        this.genreName = name;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genreId=" + genreId +
                ", genreName='" + genreName + '\'' +
                ", movies=" + movies +
                '}';
    }
}
