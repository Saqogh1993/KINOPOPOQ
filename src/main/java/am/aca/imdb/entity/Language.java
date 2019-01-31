package am.aca.imdb.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "language")
public class Language implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lang_id")
    private long langId;

    @Column(name = "lang_name")
    private String languageName;

    @OneToMany(mappedBy = "languages", cascade = {CascadeType.ALL})
    private List<Movie> movies = new ArrayList<>();

    public Language(String languageName) {
        this.langId = languageName.hashCode();
        this.languageName = languageName;
    }

    public Language() {
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public long getLangId() {
        return langId;
    }

    public void setLangId(int langId) {
        this.langId = langId;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String name) {
        this.languageName = name;
    }

}