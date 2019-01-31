package am.aca.imdb.dto;

import java.util.List;

public class GenreDto {
    private Long genreId;
    private String genreName;
    private List<String> genreMovies;

    public List<String> getGenreMovies() {
        return genreMovies;
    }

    public void setGenreMovies(List<String> genreMovies) {
        this.genreMovies = genreMovies;
    }

    public GenreDto() {
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
