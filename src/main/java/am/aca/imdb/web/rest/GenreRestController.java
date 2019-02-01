package am.aca.imdb.web.rest;

import am.aca.imdb.repository.dao.GenreRepository;
import am.aca.imdb.service.dto.GenreDto;
import am.aca.imdb.service.implementation.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GenreRestController {

    private GenreService genreService;

    public GenreRestController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/genres")
    public List<GenreDto> findALlGenres(){
        return genreService.findALlGenres();
    }
}
