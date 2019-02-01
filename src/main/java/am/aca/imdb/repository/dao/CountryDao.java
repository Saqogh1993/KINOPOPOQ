package am.aca.imdb.repository.dao;

import am.aca.imdb.repository.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryDao extends JpaRepository<Country, Long> {
}
