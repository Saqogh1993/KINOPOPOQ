package am.aca.kinopopoq.web.rest;

//import org.springframework.security.access.prepost.PreAuthorize;
import com.sun.deploy.net.HttpResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import am.aca.kinopopoq.service.dto.MovieDto;
import am.aca.kinopopoq.service.implementation.MovieService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.stream.Collectors;

@RestController
public class MovieRestController {

    private MovieService movieService;

    public MovieRestController(MovieService movieService) {
        this.movieService = movieService;
    }

//    @GetMapping("/")
//    public List<MovieDto> findAllMovies() {
//        return movieService.findAllMovies();
//    }

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
        modelAndView.addObject("movies", movieService.findAllMovies().stream().limit(50L).collect(Collectors.toList()));
        return modelAndView;
    }
//
//    @GetMapping("/movies/home")
//    public ModelAndView getMovies(){
//        ModelAndView modelAndView = new ModelAndView("home");
//        modelAndView.addObject("movies", movieService.findAllMovies());
//        return modelAndView;
//    }
    @GetMapping("/movact/{name}")
    public ModelAndView getMoviesByActor(@PathVariable(name = "name") String name){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("actormovies", movieService.findMoviesByActorName(name).stream()
                .map(MovieDto::getTitle).collect(Collectors.toList()));
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
}
