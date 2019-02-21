package am.aca.kinopopoq.service.dto;

import am.aca.kinopopoq.repository.entity.Rating;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RatingDto implements Serializable {
    private Long id;
    private Long rating;

    public RatingDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public static List<RatingDto> mapEntitiesToDto(List<Rating> entities) {
        List<RatingDto> dtos = new ArrayList<>();
        if(entities == null)
            return dtos;

        for(Rating rating: entities) {
            dtos.add(mapEntityToDto(rating));
        }
        return dtos;
    }

    public static RatingDto mapEntityToDto(Rating rating) {
        if (rating == null)
            return null;

        RatingDto ratingDto = new RatingDto();

        ratingDto.setId(rating.getId());
        ratingDto.setRating(rating.getRating());
        return ratingDto;
    }

    public static Rating mapDtoToEntity(RatingDto dto) {
        if (dto == null)
            return null;

        Rating rating = new Rating();
        rating.setId(dto.getId());
        rating.setRating(dto.getRating());

        return rating;
    }

    public static List<Rating> mapDtosToEntity(List<RatingDto> ratingDtos) {
        List<Rating> ratings = new ArrayList<>();
        if (ratingDtos == null) {
            return ratings;
        }

        for (RatingDto ratingDto : ratingDtos) {
            ratings.add(mapDtoToEntity(ratingDto));
        }
        return ratings;
    }

}
