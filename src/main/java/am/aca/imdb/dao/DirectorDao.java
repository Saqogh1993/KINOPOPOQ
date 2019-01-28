package am.aca.imdb.dao;

import am.aca.imdb.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DirectorDao extends JpaRepository<Director, Long> {


    @Override
    List<Director> findAll();

    @Override
    Director findOne(Long aLong);
}
