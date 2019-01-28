package am.aca.imdb.rest;

import am.aca.imdb.dao.GenreDAO;
import am.aca.imdb.entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GenreRestController {

    private GenreDAO genreDAO;

    @Autowired
    public GenreRestController(GenreDAO genreDAO) {
        this.genreDAO = genreDAO;
    }

    @GetMapping("/genres")
    public List<Genre> findAllGenres() {
        return genreDAO.findAll();
    }

}
