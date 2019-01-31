package am.aca.imdb.dao;

import am.aca.imdb.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActorDAO extends JpaRepository<Actor, Long> {

}
