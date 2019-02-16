package am.aca.kinopopoq.repository.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "director")
public class Director implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "dir_id")
    private long id;

    @Column(name = "dir_name")
    private String name;

    @OneToMany(mappedBy = "director",cascade = {CascadeType.ALL})
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
