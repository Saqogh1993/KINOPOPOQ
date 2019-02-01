package am.aca.imdb.repository.dao;

import am.aca.imdb.repository.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Long> {
}
