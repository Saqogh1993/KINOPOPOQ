package am.aca.imdb.service.dto;

import am.aca.imdb.repository.entity.Actor;
import am.aca.imdb.repository.entity.Genre;
import am.aca.imdb.repository.entity.Movie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MovieDto implements Serializable {

    private long id;
    private String title;
    private DirectorDto directorDto;
    private int year;
    private int duration;
    private String budget;
    private String description;
    private List<ActorDto> actorDtos;
    private List<GenreDto> genreDtos;
    private LanguageDto languageDto;
    private CountryDto countryDto;
    private String rating;
    private String pg;
    private String movieLink;


    public static List<MovieDto> mapEntitiesToDto(List<Movie> movieList) {
        List<MovieDto> dtos = new ArrayList<>();
        if(movieList == null)
            return dtos;

        for (Movie movie : movieList) {
            dtos.add(mapEntityToDto(movie));
        }

        return dtos;
    }

    public static MovieDto mapEntityToDto(Movie movie) {
        if (movie == null)
            return null;

        MovieDto movieDto = new MovieDto();
        movieDto.setId(movie.getMvId());
        movieDto.setTitle(movie.getTitle());
        movieDto.setBudget(movie.getBudget());
        movieDto.setDescription(movie.getDescription());
        movieDto.setDuration(movie.getDuration());
        movieDto.setPg(movie.getPg());
        movieDto.setMovieLink(movie.getMovieLink());
        movieDto.setRating(movie.getRating());
        movieDto.setYear(movie.getYear());

        Set<Actor> actorSet = movie.getActors();
        if(actorSet != null) {
            List<Actor> actorList = new ArrayList<>(actorSet);
            movieDto.setActorDtos(ActorDto.mapEntitiesToDto(actorList));
        }

        Set<Genre> genreSet = movie.getGenres();
        if(genreSet != null){
            List<Genre> genreList = new ArrayList<>(genreSet);
            movieDto.setGenreDtos(GenreDto.mapEntitiesToDto(genreList));
        }

        movieDto.setCountryDto(CountryDto.mapEntityToDto(movie.getCountry()));

        movieDto.setDirectorDto(DirectorDto.mapEntityToDto(movie.getDirector()));

        movieDto.setLanguageDto(LanguageDto.mapEntityToDto(movie.getLanguage()));

        return movieDto;
    }

    public static Movie mapDtoToEntity(MovieDto movieDto) {
        if (movieDto == null)
            return null;

        Movie movie = new Movie();
        movie.setMvId(movieDto.getId());
        movie.setBudget(movieDto.getBudget());
        movie.setDescription(movieDto.getDescription());
        movie.setMovieLink(movieDto.getMovieLink());
        movie.setPg(movieDto.getPg());
        movie.setDuration(movieDto.getDuration());
        movie.setRating(movieDto.getRating());
        movie.setYear(movieDto.getYear());
        movie.setTitle(movieDto.getTitle());
        movie.setDirector(DirectorDto.mapDtoToEntity(movieDto.getDirectorDto()));
        movie.setActors(ActorDto.mapDtosToEntity(movieDto.getActorDtos()));
        movie.setGenres(GenreDto.mapDtosToEntity(movieDto.getGenreDtos()));
        movie.setCountry(CountryDto.mapDtoToEntity(movieDto.getCountryDto()));
        movie.setLanguage(LanguageDto.mapDtoToEntity(movieDto.getLanguageDto()));

        return movie;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DirectorDto getDirectorDto() {
        return directorDto;
    }

    public void setDirectorDto(DirectorDto directorDto) {
        this.directorDto = directorDto;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ActorDto> getActorDtos() {
        return actorDtos;
    }

    public void setActorDtos(List<ActorDto> actorDtos) {
        this.actorDtos = actorDtos;
    }

    public List<GenreDto> getGenreDtos() {
        return genreDtos;
    }

    public void setGenreDtos(List<GenreDto> genreDtos) {
        this.genreDtos = genreDtos;
    }

    public LanguageDto getLanguageDto() {
        return languageDto;
    }

    public void setLanguageDto(LanguageDto languageDto) {
        this.languageDto = languageDto;
    }

    public CountryDto getCountryDto() {
        return countryDto;
    }

    public void setCountryDto(CountryDto countryDto) {
        this.countryDto = countryDto;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPg() {
        return pg;
    }

    public void setPg(String pg) {
        this.pg = pg;
    }

    public String getMovieLink() {
        return movieLink;
    }

    public void setMovieLink(String movieLink) {
        this.movieLink = movieLink;
    }

}
