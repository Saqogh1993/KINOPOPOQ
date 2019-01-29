package am.aca.imdb.rest;

import am.aca.imdb.dao.GenreDao;
import am.aca.imdb.entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class GenreRestController {
    private GenreDao genreDao;
    @Autowired
    public GenreRestController(GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    @GetMapping("/genres")
    public List<Genre> findALlGenres(){
        List<Genre> genres = genreDao.findAll();
        return genres;

    }
}
