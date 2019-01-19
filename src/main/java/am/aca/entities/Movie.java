package am.aca.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @Column(name = "id")
    private String id;
    private String title;
    private String director;
    private int year;
    private int duration;
    private long budget;
    private String description;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "actor_movie",
            joinColumns = {@JoinColumn (name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "actor_id")}

    )
    private List<Actor> actors = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id")
    private List<Genre> genres = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id")
    private List<Country> countries = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "lang_id")
    private Language language;

    public Movie () {}

    public Movie(String title, String director, int year, int duration, long budget, String description, List<Actor> actors, List<Genre> genres, List<Country> countries, Language language) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.duration = duration;
        this.budget = budget;
        this.description = description;
        this.actors = actors;
        this.genres = genres;
        this.countries = countries;
        this.language = language;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
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

    public long getBudget() {
        return budget;
    }

    public void setBudget(long budget) {
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

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", year=" + year +
                ", duration=" + duration +
                ", budget=" + budget +
                ", description='" + description + '\'' +
                ", genres=" + genres.toString() +
                ", countries=" + countries.toString() +
                ", language=" + language +
                '}';
    }
}
