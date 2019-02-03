package am.aca.imdb.web.rest;

import am.aca.imdb.repository.dao.DirectorRepository;
import am.aca.imdb.service.dto.DirectorDto;
import am.aca.imdb.service.implementation.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class DirectorRestController {

    private DirectorService directorService;

    public DirectorRestController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping("/directors")
    public List<DirectorDto> findAllDirectors(){
        return directorService.findAllDirectors();
    }

}
