package am.aca.imdb.dto;

public class LanguageDto {
    private Long langId;
    private String langName;

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
