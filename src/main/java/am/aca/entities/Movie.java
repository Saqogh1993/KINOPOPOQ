package am.aca.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movie")
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int mvId;

    private String title;

    @OneToOne(cascade = {CascadeType.ALL})
    private Director directors;

    private int year;
    private int duration;
    private String budget;
    private String description;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "actor_movie",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "actor_id")}
    )
    private Set<Actor> actors = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "movie_genre",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "genre_id")}
    )
    private Set<Genre> genres = new HashSet<>();

    @ManyToOne(cascade = {CascadeType.ALL}, targetEntity = Country.class)
    private Country countries;

    @ManyToOne(cascade = {CascadeType.ALL})
    private Language languages;

    private String rating;

    private String pg;
    @Column(name = "movie_link")
    private String movieLink;

    public Movie() {
    }

    public Movie(int mvId, String title, Director directors, int year, int duration, String budget, String description, Set<Actor> actors, Set<Genre> genres, Country countries, Language languages, String rating, String pg, String movieLink) {
        this.mvId = mvId;
        this.title = title;
        this.directors = directors;
        this.year = year;
        this.duration = duration;
        this.budget = budget;
        this.description = description;
        this.actors = actors;
        this.genres = genres;
        this.countries = countries;
        this.languages = languages;
        this.rating = rating;
        this.pg = pg;
        this.movieLink = movieLink;
    }

    public int getMvId() {
        return mvId;
    }

    public void setMvId(int mvId) {
        this.mvId = mvId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Director getDirectors() {
        return directors;
    }

    public void setDirectors(Director directors) {
        this.directors = directors;
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

    public Country getCountries() {
        return countries;
    }

    public void setCountries(Country countries) {
        this.countries = countries;
    }

    public Language getLanguages() {
        return languages;
    }

    public void setLanguages(Language languages) {
        this.languages = languages;
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
}
