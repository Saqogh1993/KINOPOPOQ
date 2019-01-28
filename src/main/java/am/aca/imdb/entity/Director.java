package am.aca.imdb.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "director")
public class Director implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dir_id")
    private int id;

    @Column(name = "dir_name")
    private String name;

    @OneToOne(mappedBy = "directors", cascade = {CascadeType.ALL})
    private Movie movies = new Movie();

    public Director() {
    }

    public Director(String name) {
        this.id = name.hashCode();
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Movie getMovies() {
        return movies;
    }

    public void setMovies(Movie movies) {
        this.movies = movies;
    }

}
