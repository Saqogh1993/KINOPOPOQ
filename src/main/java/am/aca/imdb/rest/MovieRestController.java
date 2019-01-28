package am.aca.imdb.rest;

import am.aca.imdb.dao.MovieDAO;
import am.aca.imdb.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieRestController {
    private MovieDAO movieDAO;

    @Autowired
    public MovieRestController(MovieDAO movieDAO) {
        this.movieDAO = movieDAO;
    }

    @RequestMapping("/movies")
    public List<Movie> findAllMovies() {
        return movieDAO.findAll();
    }
}
