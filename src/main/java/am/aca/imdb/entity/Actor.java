package am.aca.imdb.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "actor")
public class Actor implements Serializable {

    private static final long serialVersionUID = 1L;
    @ManyToMany(mappedBy = "actors", cascade = {CascadeType.ALL})
    private List<Movie> movies = new ArrayList<>();

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private long id;

    @Column(name = "actor_name")
    private String name;

    public Actor(String name) {
        this.id =  name.hashCode();
        this.name = name;
    }

    public Actor() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
