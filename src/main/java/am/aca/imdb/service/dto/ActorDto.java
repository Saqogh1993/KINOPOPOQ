package am.aca.imdb.service.dto;

import am.aca.imdb.repository.entity.Actor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ActorDto implements Serializable {

    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<ActorDto> mapEntitiesToDto(List<Actor> entities) {
        List<ActorDto> dtos = new ArrayList<>();
        if(entities == null)
            return dtos;

        for(Actor actor: entities) {
            dtos.add(mapEntityToDto(actor));
        }
        return dtos;
    }

    public static ActorDto mapEntityToDto(Actor actor) {
        if (actor == null)
            return null;

        ActorDto actorDto = new ActorDto();

        actorDto.setId(actor.getName().hashCode());
        actorDto.setName(actor.getName());
        return actorDto;
    }

    public static Actor mapDtoToEntity(ActorDto dto) {
        if (dto == null)
            return null;

        Actor actor = new Actor();
        actor.setId(dto.getName().hashCode());
        actor.setName(dto.getName());

        return actor;
    }
}
