package am.aca.imdb.dao;

import am.aca.imdb.dto.CountryDto;
import am.aca.imdb.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryDao extends JpaRepository<Country, Long> {
}
