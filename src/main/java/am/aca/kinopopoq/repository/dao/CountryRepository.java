package am.aca.kinopopoq.repository.dao;

import am.aca.kinopopoq.repository.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
