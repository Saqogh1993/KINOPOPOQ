package am.aca.entities;

import javax.persistence.*;

@Entity
@Table(name = "director")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dir_id")
    private int id;

    @Column(name = "dir_name")
    private String name;

    @OneToOne(mappedBy = "directors", cascade = {CascadeType.ALL})
    private Movie movies = new Movie();

    public Director() {
    }
    public Director(String name) {
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

    @Override
    public String toString() {
        return "Director{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", movies=" + movies +
                '}';
    }
}
