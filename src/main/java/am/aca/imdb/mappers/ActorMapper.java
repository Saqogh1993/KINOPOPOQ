package am.aca.imdb.mappers;

import am.aca.imdb.dto.ActorDto;
import am.aca.imdb.dto.MovieDto;
import am.aca.imdb.entity.Actor;
import am.aca.imdb.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
@Component
public class ActorMapper implements MapEntityToDto<Actor, ActorDto> {
    @Autowired
    MovieMapper movieMapper;

    @Override
    public ActorDto mapEntityToDto(Actor entity) {
        ActorDto actorDto = new ActorDto();
        actorDto.setActId(entity.getId());
        actorDto.setActName(entity.getName());
        List<MovieDto> movieDtos = movieMapper.mapEntitiesToDto(entity.getMovies());
        List<String> movieNames = movieDtos.stream()
                .map(m -> m.getMovieName())
                .collect(Collectors.toList());
        actorDto.setMovieDtos(movieNames);
        return actorDto;
    }


    @Override
    public List<ActorDto> mapEntitiesToDto(List<Actor> entities) {
        return entities.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }
}
