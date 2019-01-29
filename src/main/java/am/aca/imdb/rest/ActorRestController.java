package am.aca.imdb.rest;

import am.aca.imdb.dao.ActorDao;
import am.aca.imdb.entity.Actor;
import am.aca.imdb.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class ActorRestController {

    private ActorDao actorDao;

    @Autowired
    public ActorRestController(ActorDao actorDao) {
        this.actorDao = actorDao
        ;
    }


    @GetMapping("/actors")
    public List<Actor> findAllActors () {
        return actorDao.findAll();
    }
    @GetMapping("/actors/{id}")
    public Actor findByActorId(@PathVariable(value = "id") long id){
        return actorDao.findOne(id);
    }
    @GetMapping("/actors/movies/{id}")
    public Set<Movie> findMoviesByActorId(@PathVariable(value = "id") long id){
        Set<Movie> movies = actorDao.findOne(id).getMovies();
        return movies;
    }
}

