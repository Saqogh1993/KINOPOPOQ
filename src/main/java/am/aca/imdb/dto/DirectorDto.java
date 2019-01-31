package am.aca.imdb.dto;

import java.util.List;

public class DirectorDto {
    private Long dirId;
    private String dirName;
    private List<String> dirMovies;

    public List<String> getDirMovies() {
        return dirMovies;
    }

    public void setDirMovies(List<String> dirMovies) {
        this.dirMovies = dirMovies;
    }

    public DirectorDto() {
    }

    public Long getDirId() {
        return dirId;
    }

    public void setDirId(Long dirId) {
        this.dirId = dirId;
    }

    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName;
    }
}
