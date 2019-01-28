package am.aca.imdb.dao;

import am.aca.imdb.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActorDao extends JpaRepository<Actor, Long> {

    @Override
    List<Actor> findAll();

    @Override
    Actor findOne(Long aLong);
}
