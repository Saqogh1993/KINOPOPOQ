package am.aca.imdb.repository.dao;

import am.aca.imdb.repository.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
    Actor findActorByName(String name);
}
