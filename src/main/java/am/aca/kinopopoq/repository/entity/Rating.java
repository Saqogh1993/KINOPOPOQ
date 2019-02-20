package am.aca.kinopopoq.repository.entity;


import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "rating")
public class Rating {

    @Id
    @Column(name = "rating_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long rating;

    @ManyToOne
    private User user;

    @ManyToOne
    private Movie movie;

    public Rating() {
    }

    public Long getId() {
        return id;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
