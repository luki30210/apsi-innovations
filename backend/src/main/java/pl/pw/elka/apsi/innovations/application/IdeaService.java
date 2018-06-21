package pl.pw.elka.apsi.innovations.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.pw.elka.apsi.innovations.application.assembler.IdeaAssembler;
import pl.pw.elka.apsi.innovations.domain.idea.Idea;
import pl.pw.elka.apsi.innovations.domain.idea.IdeaRepository;
import pl.pw.elka.apsi.innovations.domain.keyword.Keyword;
import pl.pw.elka.apsi.innovations.domain.subject.Subject;
import pl.pw.elka.apsi.innovations.shared.exception.IdeaNotFoundException;
import pl.pw.elka.apsi.innovations.webui.dto.IdeaDetailsDto;
import pl.pw.elka.apsi.innovations.webui.dto.IdeaDto;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class IdeaService {
    private final IdeaRepository ideaRepository;

    private final KeywordService keywordService;

    private final SubjectService subjectService;

    private final RatingService ratingService;

    @Autowired
    public IdeaService(IdeaRepository ideaRepository, KeywordService keywordService, SubjectService subjectService, @Lazy RatingService ratingService) {
        this.ideaRepository = ideaRepository;
        this.keywordService = keywordService;
        this.subjectService = subjectService;
        this.ratingService = ratingService;
    }

    public IdeaDto addIdea(IdeaDto ideaDto) {
        Idea newIdea = new Idea();
        newIdea.setName(ideaDto.getName());
        newIdea.setDescription(ideaDto.getDescription());

        final Subject subject = subjectService.getSubject(ideaDto.getSubject().getId());
        newIdea.setSubject(subject);

        Set<Keyword> keywords = keywordService.getOrCreateAndGetIfNotExist(ideaDto.getKeywords());
        newIdea.setKeywords(keywords);

        newIdea.setBenefits(ideaDto.getBenefits());
        newIdea.setCosts(ideaDto.getCosts());

        newIdea = ideaRepository.save(newIdea);

        return IdeaAssembler.assemble(newIdea);
    }

    public List<IdeaDto> getIdeas(Pageable pageable) {
        final List<Idea> ideas = ideaRepository.findAll(pageable).stream().collect(Collectors.toList());
        return IdeaAssembler.assemble(ideas);
    }

    public List<IdeaDetailsDto> getIdeasWithDetails(Pageable pageable) {
        final List<Idea> ideas = ideaRepository.findAll(pageable).stream().collect(Collectors.toList());
        return ideas.stream().map(idea -> {
            final Double meanRatingForIdea = ratingService.getMeanRatingForIdea(idea.getId());
            return IdeaAssembler.assembleWithDetails(idea, meanRatingForIdea);
        }).collect(Collectors.toList());
    }

    public Long getIdeasCount() {
        return ideaRepository.count();
    }

    public IdeaDetailsDto getIdeaDetailsDto(Long id) {
        final Optional<Idea> idea = ideaRepository.findById(id);
        if (idea.isPresent()) {
            return IdeaAssembler.assembleWithDetails(idea.get(), null);
        }
        throw new IdeaNotFoundException("Idea with id " + id + " does not exist.");
    }

    public Idea getIdea(Long id) {
        final Optional<Idea> idea = ideaRepository.findById(id);
        if (idea.isPresent()) {
            return idea.get();
        }
        throw new IdeaNotFoundException("Idea with id " + id + " does not exist.");
    }


    public Boolean exists(Long ideaId) {
        return ideaRepository.existsById(ideaId);
    }

}
