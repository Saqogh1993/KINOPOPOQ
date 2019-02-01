package am.aca.imdb.repository.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "language")
public class Language implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "lang_id")
    private long langId;

    @Column(name = "lang_name")
    private String languageName;

    @OneToMany(mappedBy = "language", cascade = {CascadeType.ALL})
    private Set<Movie> movies;

    public Language(String languageName) {
        this.langId = languageName.hashCode();
        this.languageName = languageName;
    }

    public Language() {
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set movies) {
        this.movies = movies;
    }

    public long getLangId() {
        return langId;
    }

    public void setLangId(long langId) {
        this.langId = langId;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String name) {
        this.languageName = name;
    }

}
