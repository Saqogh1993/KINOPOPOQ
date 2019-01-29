package am.aca.imdb.rest;

import am.aca.imdb.dao.DirectorDao;
import am.aca.imdb.entity.Director;
import am.aca.imdb.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class DirectorRestController {
    private DirectorDao directorDao;
    @Autowired
    public DirectorRestController(DirectorDao directorDao) {
        this.directorDao = directorDao;
    }

    @GetMapping("/directors")
    public List<Director> findAllDirectors(){
        return directorDao.findAll();
    }

    @GetMapping("/directors/movies/{id}")
    public Set<Movie> findMoviesById(@PathVariable(value = "id") long id){
        Set<Movie> dirMpvies = directorDao.findOne(id).getMovies();
        return dirMpvies;
    }
}
