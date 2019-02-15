package am.aca.kinopopoq.repository.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "director")
public class Director implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "dir_id")
    private Long id;

    @Column(name = "dir_name")
    private String name;

    @OneToMany(mappedBy = "director",cascade = {CascadeType.ALL})
    private Set<Movie> movies = new HashSet<>();

    public Director() {
    }

    public Director(String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
