package am.aca.imdb.web.rest;

import am.aca.imdb.repository.dao.MovieRepository;
import am.aca.imdb.service.dto.MovieDto;
import am.aca.imdb.service.implementation.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    @GetMapping("/")
    public ModelAndView getMovies(){
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("movies",findAllMovies());
        return modelAndView;
    }
    @GetMapping("/movact/{name}")
    @ResponseBody
    public ModelAndView getMoviesByActor(@PathVariable(name = "name") String name){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("actormovies",findMoviesByActorsName(name).stream()
        .map(MovieDto::getTitle).collect(Collectors.toList()));
        return modelAndView;
    }

}
