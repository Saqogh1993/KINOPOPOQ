package am.aca.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "actor")
public class Actor {

    @Id
    @Column(name = "act_id")
    private String actId;

    @Column(name = "act_name")
    private String actName;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "actor_movie",
            joinColumns = {@JoinColumn (name = "actor_id")},
            inverseJoinColumns = {@JoinColumn(name = "movie_id")}
    )
    private List<Movie> movies = new ArrayList<>();

    public Actor() {}

    public Actor(String actName, List<Movie> movies) {
        this.actName = actName;
        this.movies = movies;
    }

    public String  getActId() {
        return actId;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String name) {
        this.actName = name;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "am.aca.entities.Actor{" +
                "id=" + actId +
                ", name='" + actName + '\'' +
//                ", movies=" + movies +
                '}';
    }
}
