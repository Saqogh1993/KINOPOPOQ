package am.aca.imdb.service.implementation;

import am.aca.imdb.repository.dao.GenreRepository;
import am.aca.imdb.service.dto.GenreDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GenreService {

    private GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<GenreDto> findALlGenres(){
        return GenreDto.mapEntitiesToDto(genreRepository.findAll());
    }
}
