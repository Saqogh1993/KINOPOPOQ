package am.aca.imdb.service.dto;

import am.aca.imdb.repository.entity.Genre;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public static Genre mapDtoToEntity(GenreDto dto) {
        if (dto == null)
            return null;

        Genre genre = new Genre();
        genre.setGenreId(dto.getId());
        genre.setGenreName(dto.getName());

        return genre;
    }

    public static Set<Genre> mapDtosToEntity(List<GenreDto> genreDtos) {
        Set<Genre> genreSet = new HashSet<>();
        if (genreDtos == null) {
            return genreSet;
        }

        for (GenreDto genreDto : genreDtos) {
            genreSet.add(mapDtoToEntity(genreDto));
        }
        return genreSet;
    }


}
