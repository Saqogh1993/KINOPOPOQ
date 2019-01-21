package am.aca.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "language")
public class Language {

    @Id
    @Column(name = "lang_id")
    private String id;

    @Column(name = "lang_name")
    private String langName;

    public Language () {}

    public Language(String langName) {
        this.langName = langName;
    }

    public String getId() {
        return id;
    }

    public String getLangName() {
        return langName;
    }

    public void setLangName(String langName) {
        this.langName = langName;
    }

    @Override
    public String toString() {
        return "Language{" +
                "id='" + id + '\'' +
                ", langName='" + langName + '\'' +
                '}';
    }
}
