package am.aca.imdb.dao;

import am.aca.imdb.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorDAO extends JpaRepository<Actor, Long> {

}
