package am.aca.kinopopoq.web.rest;

import am.aca.kinopopoq.service.dto.MovieDto;
import am.aca.kinopopoq.service.implementation.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MovieRestController {

    private MovieService movieService;

    public MovieRestController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public List<MovieDto> findAllMovies() {
        return movieService.findAllMovies();
    }

    @GetMapping("/movies/id")
    public MovieDto findByMovieId(@RequestParam Long id) {
        return movieService.findMovieById(id);
    }

    @GetMapping("/movies/title")
    public MovieDto findByMovieTitle(@RequestParam String title) {

        return movieService.findMovieByTitle(title);
    }
    @GetMapping("movies/name")
    public List<MovieDto> findMoviesByActorsName(@RequestParam String name){
        return movieService.findMoviesByActorName(name);
    }
    @GetMapping("/home")
    public ModelAndView getMovies(){
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("movies",findAllMovies().stream()
        .limit(20L).collect(Collectors.toList()));
        return modelAndView;
    }
    @GetMapping("/movact/{name}")
    public ModelAndView getMoviesByActor(@PathVariable(name = "name") String name){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("actormovies",findMoviesByActorsName(name).stream()
        .map(MovieDto::getTitle).collect(Collectors.toList()));
        return modelAndView;
    }

}