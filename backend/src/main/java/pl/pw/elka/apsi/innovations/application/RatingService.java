package pl.pw.elka.apsi.innovations.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pw.elka.apsi.innovations.domain.rating.RatingRepository;
import pl.pw.elka.apsi.innovations.shared.exception.IdeaNotFoundException;

@Service
public class RatingService {
    private RatingRepository ratingRepository;

    private IdeaService ideaService;

    @Autowired
    public RatingService(RatingRepository ratingRepository, IdeaService ideaService) {
        this.ratingRepository = ratingRepository;
        this.ideaService = ideaService;
    }

    public Double getMeanRatingForIdea(Long ideaId) {
        if (!ideaService.exists(ideaId)) {
            throw new IdeaNotFoundException("Couldn't calculate mean rating of non existing idea (id = " + ideaId + ")");
        }

        return ratingRepository.getMeanRating(ideaId);
    }
}
