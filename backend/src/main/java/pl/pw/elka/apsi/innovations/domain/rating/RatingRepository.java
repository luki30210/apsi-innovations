package pl.pw.elka.apsi.innovations.domain.rating;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Łukasz on 2018-05-13.
 */
public interface RatingRepository extends JpaRepository<Rating, Long> {
    @Query("select avg(r.value) from Rating r where r.idea.id = ?1")
    Double getMeanRating(Long ideaId);
}
