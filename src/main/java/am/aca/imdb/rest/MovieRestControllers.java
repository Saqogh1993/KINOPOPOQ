package am.aca.imdb.rest;

import am.aca.imdb.dao.MovieDao;
import am.aca.imdb.dto.MovieDto;
import am.aca.imdb.mappers.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class MovieRestControllers  {
    @Autowired
    private MovieMapper movieMapper;
    private  MovieDao movieDao;
    public MovieRestControllers(MovieDao movieDao) {
        this.movieDao = movieDao;
    }


    @GetMapping("/movies")
    public List<MovieDto> findAllMovies() {
        return movieMapper.mapEntitiesToDto(movieDao.findAll());
    }
}
