package am.aca.kinopopoq.web.rest;

import am.aca.kinopopoq.repository.dao.GenreRepository;
import am.aca.kinopopoq.repository.dao.MovieRepository;
import am.aca.kinopopoq.service.implementation.LimitOffsetPageRequest;
import am.aca.kinopopoq.service.implementation.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
public class SearchController {
    @Autowired
    private MovieService movieService;
    private MovieRepository movieRepository;
    public SearchController(GenreRepository genreRepository, MovieRepository movieRepository, MovieService movieService) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam(required = false) Optional<String> search,
                               @RequestParam(required = false) Integer limit,
                               @RequestParam(required = false) Integer offset,
                               ModelAndView modelAndView){
        String searchVal = search.orElse("");
        offset = offset == null ? 0 : offset;
        limit = limit == null ? 10 : limit;
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "avg_rating"));
        modelAndView.setViewName("home");
        LimitOffsetPageRequest pageable = new LimitOffsetPageRequest(limit, offset,sort);
        modelAndView.addObject("keyword", searchVal);
        modelAndView.addObject("result", movieRepository.findMoviesByTitle(searchVal, pageable));
        modelAndView.addObject("actor_movies",movieRepository.findAllByActorsName(searchVal));
        modelAndView.addObject("result_size", movieRepository.findMoviesByTitleCount(searchVal));
        return modelAndView;
    }

}
