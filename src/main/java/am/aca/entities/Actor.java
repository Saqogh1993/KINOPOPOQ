package am.aca.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "actor")
public class Actor implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToMany(mappedBy = "actors", cascade = {CascadeType.ALL})
    private Set<Movie> movies = new HashSet<>();

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private int id;

    @Column(name = "actor_name")
    private String name;

    public Actor(String name) {
        this.id = name.hashCode();
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

}
