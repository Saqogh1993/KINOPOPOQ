package am.aca.kinopopoq.repository.dao;

import am.aca.kinopopoq.repository.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {
}