package pl.pw.elka.apsi.innovations.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pw.elka.apsi.innovations.application.assembler.RatingAssembler;
import pl.pw.elka.apsi.innovations.domain.idea.Idea;
import pl.pw.elka.apsi.innovations.domain.idea.IdeaRepository;
import pl.pw.elka.apsi.innovations.domain.rating.Rating;
import pl.pw.elka.apsi.innovations.domain.rating.RatingRepository;
import pl.pw.elka.apsi.innovations.shared.exception.IdeaNotFoundException;
import pl.pw.elka.apsi.innovations.webui.dto.RatingDto;

@Service
public class RatingService {
    private RatingRepository ratingRepository;
    private IdeaRepository ideaRepository;

    private IdeaService ideaService;

    @Autowired
    public RatingService(RatingRepository ratingRepository, IdeaRepository ideaRepository, IdeaService ideaService) {
        this.ratingRepository = ratingRepository;
        this.ideaRepository = ideaRepository;
        this.ideaService = ideaService;
    }

    public RatingDto addRating(RatingDto ratingDto){
        Rating newRating = new Rating();
        final Idea idea = ideaService.getIdea(ratingDto.getIdeaId());
        newRating.setIdea(idea);
        newRating.setValue(ratingDto.getValue());
        newRating.setOpinion(ratingDto.getOpinion());
        ratingRepository.save(newRating);

        return RatingAssembler.assemble(newRating);

    }

    public Double getMeanRatingForIdea(Long ideaId) {
        if (!ideaService.exists(ideaId)) {
            throw new IdeaNotFoundException("Couldn't calculate mean rating of non existing idea (id = " + ideaId + ")");
        }

        return ratingRepository.getMeanRating(ideaId);
    }
}
