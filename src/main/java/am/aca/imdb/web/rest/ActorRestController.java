package am.aca.imdb.web.rest;

import am.aca.imdb.repository.dao.ActorDao;
import am.aca.imdb.repository.entity.Actor;
import am.aca.imdb.repository.entity.Movie;
import am.aca.imdb.service.dto.ActorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class ActorRestController {

    @Autowired
    private ActorDao actorDao;

    @GetMapping("/actors")
    public List<ActorDto> findAllActors () {
        return ActorDto.mapEntitiesToDto(actorDao.findAll());
    }

}

