package am.aca.imdb.mappers;

import am.aca.imdb.dto.DirectorDto;
import am.aca.imdb.entity.Director;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DirectorMapper implements MapEntityToDto<Director, DirectorDto> {
    @Override
    public DirectorDto mapEntityToDto(Director entity) {
        DirectorDto directorDto = new DirectorDto();
        directorDto.setDirId(entity.getId());
        directorDto.setDirName(entity.getName());
        return directorDto;
    }

    @Override
    public List<DirectorDto> mapEntitiesToDto(List<Director> entities) {
        return entities.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }
}
