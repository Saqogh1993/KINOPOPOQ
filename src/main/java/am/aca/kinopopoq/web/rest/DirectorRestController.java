package am.aca.kinopopoq.web.rest;

import am.aca.kinopopoq.service.dto.DirectorDto;
import am.aca.kinopopoq.service.implementation.DirectorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController("/directors")
public class DirectorRestController {

    private DirectorService directorService;

    public DirectorRestController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping("/")
    public List<DirectorDto> findAllDirectors(){
        return directorService.findAllDirectors();
    }

}
