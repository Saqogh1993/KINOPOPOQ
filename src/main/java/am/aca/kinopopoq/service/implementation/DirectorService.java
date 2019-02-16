package am.aca.kinopopoq.service.implementation;

import am.aca.kinopopoq.repository.dao.DirectorRepository;
import am.aca.kinopopoq.service.dto.DirectorDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DirectorService {

    private DirectorRepository directorRepository;

    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    public List<DirectorDto> findAllDirectors(){
        return DirectorDto.mapEntitiesToDto(directorRepository.findAll());
    }
}
