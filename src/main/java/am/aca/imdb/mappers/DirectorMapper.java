package am.aca.imdb.mappers;

import am.aca.imdb.dto.DirectorDto;
import am.aca.imdb.dto.MovieDto;
import am.aca.imdb.entity.Director;
import am.aca.imdb.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class DirectorMapper implements MapEntityToDto<Director, DirectorDto> {
    @Autowired
    private MovieMapper movieMapper;
    @Override
    public DirectorDto mapEntityToDto(Director entity) {
        DirectorDto directorDto = new DirectorDto();
        directorDto.setDirId(entity.getId());
        directorDto.setDirName(entity.getName());
        List<MovieDto> movieDtos = movieMapper.mapEntitiesToDto(entity.getMovies());
        List<String> movieNames = movieDtos.stream()
                .map(m -> m.getMovieName())
                .collect(Collectors.toList());
        directorDto.setDirMovies(movieNames);
        return directorDto;
    }

    @Override
    public List<DirectorDto> mapEntitiesToDto(List<Director> entities) {
        return entities.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }
}
