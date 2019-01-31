package am.aca.imdb.dto;

import am.aca.imdb.entity.Movie;
import am.aca.imdb.mappers.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import java.util.List;
import java.util.Set;

public class ActorDto {
    private Long actId;
    private String actName;
    private List<String> movieDtos;

    public List<String> getMovieDtos() {
        return movieDtos;
    }

    public void setMovieDtos(List<String> movieDtos) {
        this.movieDtos = movieDtos;
    }

    public ActorDto() {
    }

    public Long getActId() {
        return actId;
    }

    public void setActId(Long actId) {
        this.actId = actId;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }
}
