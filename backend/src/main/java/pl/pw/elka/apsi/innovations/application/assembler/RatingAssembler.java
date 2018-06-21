package pl.pw.elka.apsi.innovations.application.assembler;

import org.springframework.stereotype.Component;
import pl.pw.elka.apsi.innovations.domain.rating.Rating;
import pl.pw.elka.apsi.innovations.webui.dto.RatingDto;

@Component
public class RatingAssembler {
    public static RatingDto assemble(Rating rating) {
        if (rating == null) {
            return null;
        }

        RatingDto ratingDto = new RatingDto();
        ratingDto.setId(rating.getId());
        ratingDto.setIdeaId(rating.getIdea().getId());
        ratingDto.setValue(rating.getValue());
        ratingDto.setOpinion(rating.getOpinion());
        return ratingDto;
    }
}
