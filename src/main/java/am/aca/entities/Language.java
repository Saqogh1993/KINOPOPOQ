package am.aca.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "language")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "lang_id")
    private int langId;

    @Column(name = "lang_name", updatable = false)
    private String languageName;

    @OneToMany(mappedBy = "languages" ,cascade = {CascadeType.ALL})
    private Set<Movie> movies;

    public Language(String languageName) {
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

    public int getLangId() {
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

    @Override
    public String toString() {
        return "Language{" +
                "langId=" + langId +
                ", languageName='" + languageName + '\'' +
                ", movies=" + movies +
                '}';
    }
}
