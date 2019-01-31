package am.aca.imdb.mappers;

import am.aca.imdb.dto.ActorDto;
import am.aca.imdb.entity.Actor;
import am.aca.imdb.entity.Movie;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class ActorMapper implements MapEntityToDto<Actor, ActorDto> {

    @Override
    public ActorDto mapEntityToDto(Actor actor) {
        ActorDto actorDto = new ActorDto();
        actorDto.setActId(actor.getId());
        actorDto.setActName(actor.getName());

        return actorDto;
    }

    @Override
    public List<ActorDto> mapEntitiesToDto(List<Actor> entities) {
        return entities.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }
}
