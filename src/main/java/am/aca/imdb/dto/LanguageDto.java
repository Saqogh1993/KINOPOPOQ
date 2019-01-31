package am.aca.imdb.dto;

import java.util.List;

public class LanguageDto {
    private Long langId;
    private String langName;
    private List<String> langMovies;

    public List<String> getLangMovies() {
        return langMovies;
    }

    public void setLangMovies(List<String> langMovies) {
        this.langMovies = langMovies;
    }

    public LanguageDto() {
    }

    public Long getLangId() {
        return langId;
    }

    public void setLangId(Long langId) {
        this.langId = langId;
    }

    public String getLangName() {
        return langName;
    }

    public void setLangName(String langName) {
        this.langName = langName;
    }
}
