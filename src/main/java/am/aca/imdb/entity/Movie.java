package am.aca.imdb.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "movie")
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private long mvId;

    private String title;
    @ManyToOne (cascade = {CascadeType.ALL})
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
    private List<Actor> actors = new ArrayList<>();
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "genre_movie",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "genre_id")}
    )
    private List<Genre> genres = new ArrayList<>();
    @ManyToOne(cascade = {CascadeType.ALL}, targetEntity = Country.class)
    private Country countries;
    @ManyToOne(cascade = {CascadeType.ALL})
    private Language languages;

    private String rating;

    private String pg;

    public Movie() {
    }

    public long getMvId() {
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

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
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

    private String movieLink;

    public Movie(int mvId, String title, Director directors, int year, int duration, String budget, String description, List<Actor> actors, List<Genre> genres, Country countries, Language languages, String rating, String pg, String movieLink) {
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
}
