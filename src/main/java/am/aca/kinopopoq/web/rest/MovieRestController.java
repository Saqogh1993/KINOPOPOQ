package am.aca.kinopopoq.web.rest;

//import org.springframework.security.access.prepost.PreAuthorize;
import am.aca.kinopopoq.repository.entity.Movie;

import am.aca.kinopopoq.service.dto.MovieDto;
import am.aca.kinopopoq.service.implementation.MovieService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.stream.Collectors;

@RestController
public class MovieRestController {

    private MovieService movieService;

    public MovieRestController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies/{id}")
    public MovieDto findByMovieId(@PathVariable Long id) {
        return movieService.findMovieById(id);
    }

    @GetMapping("/movies/title")
    public MovieDto findByMovieTitle(@RequestParam String title) {
        return movieService.findMovieByTitle(title);
    }

    @GetMapping("/")
    public ModelAndView findAllMoviesWithModelAndView() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("movies", movieService.findAllMovies().stream().limit(5L).collect(Collectors.toList()));
        return modelAndView;
    }
    @GetMapping("/movie/{id}")
    public ModelAndView goMovie(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("movie");
        modelAndView.addObject("movie", movieService.findMovieById(id));
        return modelAndView;
    }
    @GetMapping("/home")
    public ModelAndView getMovies() {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("movies", movieService.findAllMoviesWithPages(6, 0));
        return modelAndView;
    }
    @GetMapping("/actmovies/{name}")
    public ModelAndView getMoviesByActor(@PathVariable(name = "name") String name){
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("actor_movies", movieService.findMoviesByActorName(name));
        //.stream()
               // .map(MovieDto::getTitle).collect(Collectors.toList()));
        return modelAndView;
    }

    @PostMapping("/movies")
    @PreAuthorize("hasAuthority('ADMIN')")
    public MovieDto saveMovie(@RequestBody MovieDto movieDto) {
        return movieService.saveMovie(movieDto);
    }

    @PutMapping("/movies")
    @PreAuthorize("hasAuthority('ADMIN')")
    public MovieDto updateMovie(@RequestBody MovieDto movieDto) {
        return movieService.updateMovie(movieDto);
    }

    @DeleteMapping("/movies/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteMovie(@PathVariable Long id, HttpResponse httpResponse) {
        movieService.deleteMovie(id);
    }

    @GetMapping("/movies/get")
    public ModelAndView findPaginated(@RequestParam("limit") int limit, @RequestParam("offset") int offset) {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("movies", movieService.findAllMoviesWithPages(limit, offset));
        return modelAndView;
    }

    @GetMapping("/movies/{movieId}/rating")
    public MovieDto setRating(@PathVariable Long movieId, @RequestParam Long rating) {
        return movieService.setRating(movieId, rating);
    }

}
