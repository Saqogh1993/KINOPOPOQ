package am.aca.imdb.service.implementation;

import am.aca.imdb.repository.dao.ActorRepository;
import am.aca.imdb.service.dto.ActorDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ActorService {

    private ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public List<ActorDto> findAllActors () {
        return ActorDto.mapEntitiesToDto(actorRepository.findAll());
    }
    public ActorDto findActorByName(String name){
        return ActorDto.mapEntityToDto(actorRepository.findActorByName(name));
    }
}
