package am.aca.imdb.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "director")
public class Director implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dir_id")
    @JsonManagedReference
    private long id;

    @Column(name = "dir_name")
    @JsonManagedReference
    private String name;
    @OneToMany(mappedBy = "directors",cascade = {CascadeType.ALL})
    @JsonManagedReference
    private Set<Movie> movies = new HashSet<>();

    public Director() {
    }

    public Director(String name) {
        this.id = name.hashCode();
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
