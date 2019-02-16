package am.aca.kinopopoq.repository.dao;

import am.aca.kinopopoq.repository.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
    Actor findActorByName(String name);
}
