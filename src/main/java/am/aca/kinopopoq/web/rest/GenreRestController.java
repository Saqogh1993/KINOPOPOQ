package am.aca.kinopopoq.web.rest;

import am.aca.kinopopoq.service.dto.GenreDto;
import am.aca.kinopopoq.service.implementation.GenreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/genres")
public class GenreRestController {

    private GenreService genreService;

    public GenreRestController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/")
    public List<GenreDto> findALlGenres(){
        return genreService.findALlGenres();
    }
}
