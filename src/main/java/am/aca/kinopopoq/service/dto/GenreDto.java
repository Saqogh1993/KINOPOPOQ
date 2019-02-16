package am.aca.kinopopoq.service.dto;

import am.aca.kinopopoq.repository.entity.Genre;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GenreDto implements Serializable {

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


    public static List<GenreDto> mapEntitiesToDto(List<Genre> genreList) {
        List<GenreDto> genreDtos = new ArrayList<>();
        if (genreList == null)
            return null;

        for (Genre genre : genreList) {
            genreDtos.add(GenreDto.mapEntityToDto(genre));
        }
        return genreDtos;
    }

    public static GenreDto mapEntityToDto(Genre genre) {
        if (genre == null)
            return null;

        GenreDto genreDto = new GenreDto();
        genreDto.setId(genre.getGenreName().hashCode());
        genreDto.setName(genre.getGenreName());

        return genreDto;
    }

    public static Genre mapDtoToEntity(GenreDto genreDto) {
        return null;
    }


}
