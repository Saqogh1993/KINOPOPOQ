package am.aca.imdb.service.dto;

import am.aca.imdb.repository.entity.Genre;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GenreDto implements Serializable {

    private long id;
    private String name;
    private List<String> movieName;

    public List<String> getMovieName() {
        return movieName;
    }

    public void setMovieName(List<String> movieName) {
        this.movieName = movieName;
    }

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
        genreDto.setMovieName(genre.getMovies().stream().map(m -> m.getTitle()).collect(Collectors.toList()));
        return genreDto;
    }

    public static Genre mapDtoToEntity(GenreDto genreDto) {
        return null;
    }


}
