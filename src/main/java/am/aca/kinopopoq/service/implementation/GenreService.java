package am.aca.kinopopoq.service.implementation;

import am.aca.kinopopoq.repository.dao.GenreRepository;
import am.aca.kinopopoq.service.dto.GenreDto;
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
    public GenreDto findGenreByName(String name){
        return GenreDto.mapEntityToDto(genreRepository.findGenreByGenreName(name));
    }
}
