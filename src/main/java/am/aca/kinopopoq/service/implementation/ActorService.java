package am.aca.kinopopoq.service.implementation;

import am.aca.kinopopoq.repository.dao.ActorRepository;
import am.aca.kinopopoq.service.dto.ActorDto;
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
