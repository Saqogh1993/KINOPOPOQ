package am.aca.imdb.rest;

import am.aca.imdb.dao.MovieDao;
import am.aca.imdb.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieRestController {

    private MovieDao movieDao;

    @Autowired
    public MovieRestController(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @RequestMapping("/movies")
    public List<Movie> findAllMovies() {
        return movieDao.findAll();
    }
}
