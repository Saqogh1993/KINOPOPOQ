package am.aca.imdb.web.rest;

import am.aca.imdb.service.dto.MovieDto;
import am.aca.imdb.service.implementation.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/home")
    public ModelAndView findAllMoviesWithModelAndView() {
        ModelAndView modelAndView = new ModelAndView("home");
        List<MovieDto> collect = movieService.findAllMovies().stream().limit(10L).collect(Collectors.toList());
        modelAndView.addObject("movies", collect);
        return modelAndView;
    }

    @GetMapping("/content")
    public ModelAndView findAllMoviesContent() {
        ModelAndView modelAndView = new ModelAndView("content");
        List<MovieDto> collect = movieService.findAllMovies().stream().limit(10L).collect(Collectors.toList());
        modelAndView.addObject("content", collect);
        return modelAndView;
    }
}
