package am.aca.imdb.web.rest;

import am.aca.imdb.service.dto.ActorDto;
import am.aca.imdb.service.implementation.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class ActorRestController {

    private ActorService actorService;

    @Autowired
    public ActorRestController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/actors")
    public List<ActorDto> findAllActors() {
        return actorService.findAllActors();
    }


    @GetMapping("/a")
    public ModelAndView findAllMoviesWithModelAndView() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("actors", actorService.findAllActors());
        return modelAndView;
    }
}

