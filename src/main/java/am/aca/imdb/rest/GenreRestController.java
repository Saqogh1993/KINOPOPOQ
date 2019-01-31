package am.aca.imdb.rest;

import am.aca.imdb.dao.GenreDao;
import am.aca.imdb.dto.GenreDto;
import am.aca.imdb.mappers.GenreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class GenreRestController {
    @Autowired
    private GenreMapper genreMapper;
    private GenreDao genreDao;
    public GenreRestController(GenreDao genreDao) {
        this.genreDao = genreDao;
    }
    @GetMapping("/genres")
    public List<GenreDto> findAllActors () {
        return genreMapper.mapEntitiesToDto(genreDao.findAll());
    }
}
