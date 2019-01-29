package am.aca.imdb.dao;

import am.aca.imdb.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface DirectorDao extends JpaRepository<Director, Long> {
}
