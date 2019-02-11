package am.aca.kinopopoq.repository.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "actor")
public class Actor implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToMany(mappedBy = "actors")
    private Set<Movie> movies = new HashSet<>();

    @Id
    @Column(name = "actor_id")
    private Long id;

    @Column(name = "actor_name")
    private String name;


    public Actor(String name) {
        this.id = id;
        this.name = name;
    }

    public Actor() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
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


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + (id == null ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(id, obj);
    }
}
