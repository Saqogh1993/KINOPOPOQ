package am.aca.imdb.rest;

import am.aca.imdb.dao.MovieDao;
import am.aca.imdb.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieRestControllers  {
    private MovieDao movieDao;
    @Autowired
    public MovieRestControllers(MovieDao movieDao) {
        this.movieDao = movieDao;
    }
    @GetMapping("/movies")
    public List<Movie> findAllMovies(){
        List<Movie> movies = movieDao.findAll();
        return movies;
    }
}
