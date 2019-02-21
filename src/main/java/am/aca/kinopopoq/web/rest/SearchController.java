package am.aca.kinopopoq.web.rest;

import am.aca.kinopopoq.repository.dao.GenreRepository;
import am.aca.kinopopoq.repository.dao.MovieRepository;
import am.aca.kinopopoq.service.implementation.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class SearchController {
    @Autowired
    private MovieService movieService;
    private MovieRepository movieRepository;
    public SearchController(GenreRepository genreRepository, MovieRepository movieRepository, MovieService movieService) {
        this.movieRepository = movieRepository;
    }

    @PostMapping("/search")
    public ModelAndView search(@RequestParam String search, ModelAndView modelAndView){
        modelAndView.setViewName("home");
        modelAndView.addObject("result", movieRepository.findMoviesByTitle(search));
        modelAndView.addObject("actor_movies",movieRepository.findAllByActorsName(search));
        //modelAndView.addObject("genre_movies", movieRepository.findAllByGenres(search));
        return modelAndView;
    }
}
