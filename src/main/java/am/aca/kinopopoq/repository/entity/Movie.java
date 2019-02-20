package am.aca.kinopopoq.repository.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "movie")
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "movie_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mvId;
    private String title;
    private int year;
    private int duration;
    private String budget;
    private String description;
    private String rating;
    private String pg;
    @Column(name = "movie_link")
    private String movieLink;

    @ManyToOne()
    private Director director;

    @ManyToOne(targetEntity = Country.class)
    private Country country;

    @ManyToOne
    private Language language;

    @ManyToMany
    @JoinTable(
            name = "actor_movie",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "actor_id")}
    )
    private Set<Actor> actors = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "genre_movie",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "genre_id")}
    )
    private Set<Genre> genres = new HashSet<>();

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Rating> userRatings;

    private Double avgRating;

    public Movie() {
    }

    public Movie(Long mvId, String title, Director director, int year, int duration, String budget, String description, Set<Actor> actors, Set<Genre> genres, Country country, Language language, String rating, String pg, String movieLink) {
        this.mvId = mvId;
        this.title = title;
        this.director = director;
        this.year = year;
        this.duration = duration;
        this.budget = budget;
        this.description = description;
        this.actors = actors;
        this.genres = genres;
        this.country = country;
        this.language = language;
        this.rating = rating;
        this.pg = pg;
        this.movieLink = movieLink;
    }

    public List<Rating> getUserRatings() {
        return userRatings;
    }

    public Double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(Double avgRating) {
        this.avgRating = avgRating;
    }

    public void setUserRatings(List<Rating> userRatings) {
        this.userRatings = userRatings;
    }

    public Long getMvId() {
        return mvId;
    }

    public void setMvId(Long mvId) {
        this.mvId = mvId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPg() {
        return pg;
    }

    public void setPg(String pg) {
        this.pg = pg;
    }

    public String getMovieLink() {
        return movieLink;
    }

    public void setMovieLink(String movieLink) {
        this.movieLink = movieLink;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + (mvId == null ? 0 : mvId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(mvId, obj);
    }
}
