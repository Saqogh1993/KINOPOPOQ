package am.aca.imdb.web.rest;

import am.aca.imdb.repository.dao.GenreDao;
import am.aca.imdb.repository.entity.Genre;
import am.aca.imdb.service.dto.GenreDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GenreRestController {

    @Autowired
    private GenreDao genreDao;

    @GetMapping("/genres")
    public List<GenreDto> findALlGenres(){
        return GenreDto.mapEntitiesToDto(genreDao.findAll());
    }
}
