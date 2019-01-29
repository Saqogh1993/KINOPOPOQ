package am.aca.imdb.rest;

import am.aca.imdb.dao.ActorDao;
import am.aca.imdb.entity.Actor;
import am.aca.imdb.entity.Movie;
import com.sun.xml.internal.bind.annotation.XmlIsSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class ActorRestController {

    private final ActorDao actorDao;

    @Autowired
    public ActorRestController(ActorDao actorDao) {
        this.actorDao = actorDao;
    }

    @GetMapping("/actors")
    public List<Actor> findAllActors() {
        return actorDao.findAll();
    }

    @GetMapping("/actors/{id}")
    public Actor findByActorId(@PathVariable(value = "id") long id){
        return actorDAO.findOne(id);
    }

    @GetMapping("/actors/movies/{id}")
    public Set<Movie> findMoviesByActorId(@PathVariable(value = "id") long id){
        Set<Movie> movies = actorDAO.findOne(id).getMovies();
        return movies;
    }
    @GetMapping("/actors/{id}")
    public Actor findByActorId(@PathVariable(value = "id") long id){
        return actorDAO.findOne(id);
    }
    @GetMapping("/actors/movies/{id}")
    public Set<Movie> findMoviesByActorId(@PathVariable(value = "id") long id){
        Set<Movie> movies = actorDAO.findOne(id).getMovies();
        return movies;
    }
}

