package am.aca.imdb.rest;

import am.aca.imdb.dao.ActorDAO;
import am.aca.imdb.dto.ActorDto;
import am.aca.imdb.entity.Actor;
import am.aca.imdb.mappers.ActorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class ActorRestController {
    @Autowired
    private  ActorMapper actorMapper;
    private ActorDAO actorDAO;

    public ActorRestController(ActorDAO actorDAO) {
        this.actorDAO = actorDAO;
    }

    @GetMapping("/actors")
    public List<ActorDto> findAllActors () {

        return actorMapper.mapEntitiesToDto(actorDAO.findAll());
    }


}
