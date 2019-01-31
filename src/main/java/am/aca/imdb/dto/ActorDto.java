package am.aca.imdb.dto;

import am.aca.imdb.entity.Movie;

import javax.persistence.Entity;
import java.util.List;

public class ActorDto {
    private Long actId;
    private String actName;

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
