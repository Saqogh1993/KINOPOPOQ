package am.aca.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "genre")
public class Genre {

    @Id
    @Column(name = "genre_id")
    private String genreId;

    @Column(name = "genre_name")
    private String genreName;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "genre_movie",
            joinColumns = {@JoinColumn (name = "genre_id")},
            inverseJoinColumns = {@JoinColumn(name = "movie_id")}
    )
    private List<Movie> genreMovies = new ArrayList<>();

    public Genre () {}

    public Genre(String genreName, List<Movie> genreMovies) {
        this.genreName = genreName;
        this.genreMovies = genreMovies;
    }

    public String getGenreId() {
        return genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public List<Movie> getGenreMovies() {
        return genreMovies;
    }

    public void setGenreMovies(List<Movie> genreMovies) {
        this.genreMovies = genreMovies;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genreId='" + genreId + '\'' +
                ", genreName='" + genreName + '\'' +
                ", genreMovies=" + genreMovies +
                '}';
    }
}
