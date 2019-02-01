package am.aca.imdb.web.rest;

import am.aca.imdb.repository.dao.MovieDao;
import am.aca.imdb.service.dto.MovieDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieRestController {

    @Autowired
    private MovieDao movieDao;

    @GetMapping("/movies")
    public List<MovieDto> findAllMovies() {
        return MovieDto.mapEntitiesToDto(movieDao.findAll());
    }
}
