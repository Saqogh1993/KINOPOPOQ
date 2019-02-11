package am.aca.kinopopoq.repository.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "language")
public class Language implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "lang_id")
    private Long langId;

    @Column(name = "lang_name")
    private String languageName;

    @OneToMany(mappedBy = "language")
    private Set<Movie> movies;

    public Language() {
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set movies) {
        this.movies = movies;
    }

    public Long getLangId() {
        return langId;
    }

    public void setLangId(Long langId) {
        this.langId = langId;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String name) {
        this.languageName = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + (langId == null ? 0 : langId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(langId, obj);
    }

}
