package am.aca.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "actor")
public class Actor {

    @ManyToMany(mappedBy = "actors", cascade = {CascadeType.ALL})
    private Set<Movie> movies = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "actor_id")
    private int id;

    @Column(name = "actor_name")
    private String name;

    public Actor(String name) {
        this.name = name;
    }

    public Actor() {
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

    @Override
    public String toString() {
        return "Actor{" +
                "movies=" + movies +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
