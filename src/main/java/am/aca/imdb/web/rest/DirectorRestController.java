package am.aca.imdb.web.rest;

import am.aca.imdb.repository.dao.DirectorDao;
import am.aca.imdb.service.dto.DirectorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class DirectorRestController {

    @Autowired
    private DirectorDao directorDao;

    @GetMapping("/directors")
    public List<DirectorDto> findAllDirectors(){
        return DirectorDto.mapEntitiesToDto(directorDao.findAll());
    }

}
