package am.aca.imdb.dao;

import am.aca.imdb.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageDao extends JpaRepository<Language, Long> {
}
