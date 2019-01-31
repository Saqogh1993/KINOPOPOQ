package am.aca.imdb.rest;

import am.aca.imdb.dao.DirectorDao;
import am.aca.imdb.dto.DirectorDto;
import am.aca.imdb.entity.Movie;
import am.aca.imdb.mappers.DirectorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Set;

@RestController
public class DirectorRestController {
    @Autowired
    private DirectorMapper directorMapper;
    private DirectorDao directorDao;
    public DirectorRestController(DirectorDao directorDao) {
        this.directorDao = directorDao;
    }

    @GetMapping("/directors")
    public List<DirectorDto> findAllActors () {
        return directorMapper.mapEntitiesToDto(directorDao.findAll());
    }

}
