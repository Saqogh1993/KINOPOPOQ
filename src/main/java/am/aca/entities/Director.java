package am.aca.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "director")
public class Director {

    @Id
    @Column(name = "director_id")
    private String dirID;

    @Column(name = "director_name")
    private String dirName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id")
    List<Movie> movies = new ArrayList<>();

    public Director () {}

    public Director(String dirName, List<Movie> movies) {
        this.dirName = dirName;
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Director{" +
                "id=" + dirID +
                ", name='" + dirName + '\'' +
//                ", movies=" + movies +
                '}';
    }

    public String getId() {
        return dirID;
    }

    public String getName() {
        return dirName;
    }

    public void setName(String name) {
        this.dirName = name;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
