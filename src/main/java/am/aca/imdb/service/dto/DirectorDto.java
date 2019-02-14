package am.aca.imdb.service.dto;

import am.aca.imdb.repository.entity.Director;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DirectorDto implements Serializable {

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


    public static List<DirectorDto> mapEntitiesToDto(List<Director> directors) {
        List<DirectorDto> directorDtos = new ArrayList<>();
        if (directors == null)
            return null;

        for (Director director : directors) {
            directorDtos.add(DirectorDto.mapEntityToDto(director));
        }

        return directorDtos;
    }

    public static DirectorDto mapEntityToDto(Director director) {
        if (director == null)
            return null;

        DirectorDto directorDto = new DirectorDto();

        directorDto.setId(director.getId());
        directorDto.setName(director.getName());

        return directorDto;
    }

    public static Director mapDtoToEntity(DirectorDto directorDto) {
        if (directorDto == null) {
            return null;
        }

        Director director = new Director();

        director.setId(directorDto.getId());
        director.setName(directorDto.getName());

        return director;
    }

}
