package am.aca.kinopopoq.web.rest;

import am.aca.kinopopoq.service.dto.ActorDto;
import am.aca.kinopopoq.service.implementation.ActorService;
import am.aca.kinopopoq.service.implementation.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class ActorRestController {

    @Autowired
    private ActorService actorService;

    @Autowired
    private MovieService movieService;


    @GetMapping
    public List<ActorDto> findAllActors() {
        return actorService.findAllActors();
    }

    @GetMapping("/act/{name}")
    public ModelAndView getActors(@PathVariable(name = "name") String name){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("actors",actorService.findActorByName(name));
        modelAndView.addObject("movies", movieService.findMoviesByActorName(name));
        return modelAndView;
    }
}

