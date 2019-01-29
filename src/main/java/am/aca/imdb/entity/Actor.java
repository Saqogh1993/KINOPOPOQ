package am.aca.imdb.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "actor")
public class Actor implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonManagedReference
    @ManyToMany(mappedBy = "actors", cascade = {CascadeType.ALL})
    private Set<Movie> movies = new HashSet<>();

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "actor_id")
    @JsonManagedReference
    private long id;

    @Column(name = "actor_name")
    @JsonManagedReference
    private String name;

    public Actor(String name) {
        this.id = name.hashCode();
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

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}
