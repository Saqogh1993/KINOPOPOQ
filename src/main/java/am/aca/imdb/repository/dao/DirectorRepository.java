package am.aca.imdb.repository.dao;

import am.aca.imdb.repository.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DirectorRepository extends JpaRepository<Director, Long> {
}
