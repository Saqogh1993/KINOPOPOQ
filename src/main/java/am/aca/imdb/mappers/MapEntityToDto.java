package am.aca.imdb.mappers;

import am.aca.imdb.entity.Movie;

import java.util.List;
import java.util.Set;

public interface MapEntityToDto<T, U> {
    U mapEntityToDto(T entity);
    List<U> mapEntitiesToDto(List<T> entities);
}
