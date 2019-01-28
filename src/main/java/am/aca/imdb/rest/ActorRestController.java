package am.aca.imdb.rest;

import am.aca.imdb.dao.ActorDAO;
import am.aca.imdb.entity.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActorRestController {

    private ActorDAO actorDAO;

    @Autowired
    public ActorRestController(ActorDAO actorDAO) {
        this.actorDAO = actorDAO;
    }


    @GetMapping("/actors")
    public List<Actor> findAllActors () {
        return actorDAO.findAll();
    }
}
