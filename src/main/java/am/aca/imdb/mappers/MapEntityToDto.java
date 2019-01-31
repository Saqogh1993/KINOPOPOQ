package am.aca.imdb.mappers;

import java.util.List;

public interface MapEntityToDto<T, U> {
    U mapEntityToDto(T entity);
    List<U> mapEntitiesToDto(List<T> entities);
}
